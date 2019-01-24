package ContestSettings.Controller;

import Contest.Interface.SocketObserverController;
import ContestSettings.DataObject.ContestSettingsDataObject;
import ContestSettings.Model.ContestSettingsModel;
import ContestSettings.Model.OnlineContestSettingsModel;
import ContestSettings.View.ContestSettingsView;
import Online.Socket.Message.MessageDataObject;
import Online.Socket.Message.MessageType;
import Online.Socket.SocketCommunicatorService;
import Parameter.Model.ParameterEnum;
import Parameter.Parameters.Configurable;
import Scene.Model.ActionEnum;
import Structure.AbstractController;
import Structure.AbstractModel;
import Structure.AbstractView;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class ServerContestSettingsController extends AbstractController implements SettingsDataObjectGetterInterface, SocketObserverController {

    private final SocketCommunicatorService socketCommunicatorService;
    private final SocketReceptionObserver socketReceptionObserver;
    private ContestSettingsDataObject settingsDataObject;

    public ServerContestSettingsController(AbstractModel model, AbstractView view, SocketCommunicatorService socketCommunicatorService) {
        super(model, view);

        this.socketCommunicatorService = socketCommunicatorService;
        this.socketReceptionObserver = new SocketReceptionObserver();
        this.socketCommunicatorService.addReceptionObserver(this.socketReceptionObserver);

        Map<ParameterEnum, Configurable> defaultConfiguration = ((ContestSettingsModel) this.model).getDefaultConfiguration();
        ((ContestSettingsView) this.view).setDefaultConfiguration(defaultConfiguration);

        this.socketCommunicatorService.emit(new MessageDataObject(MessageType.SETTINGS_DEFAULT_VALUES, defaultConfiguration));

        ((ContestSettingsView) this.view).setOnlineMode(true);
        ((ContestSettingsView) this.view).registerDataChangeListener(true);
    }

    @Override
    public void update(Observable o, Object action) {
        switch ((ActionEnum) action) {
            case END_CONTEST:
                this.socketCommunicatorService.stopConnection();
                // TODO quit page
                break;
            case SETTINGS_CHANGED:
                this.socketCommunicatorService.emit(new MessageDataObject(
                        MessageType.SETTINGS_VALUES_CHANGED,
                        ((ContestSettingsView) this.view).getSettingsDataObject()
                ));
                break;
            case START_CONTEST:
                ((OnlineContestSettingsModel) this.model).firstPlayerValidate();
                ((ContestSettingsView) this.view).readyButtonSetWaiting();
                this.startContest();
                break;
        }
    }

    @Override
    public ContestSettingsDataObject getSettingsDataObject() {
        return this.settingsDataObject;
    }

    @Override
    public void stopObserver() {
        this.socketCommunicatorService.deleteReceptionObserver(this.socketReceptionObserver);
    }

    private class SocketReceptionObserver implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            MessageDataObject messageDataObject = (MessageDataObject) arg;

            switch (messageDataObject.getType()) {
                case SETTINGS_VALUES_CHANGED:
                    ((ContestSettingsView) ServerContestSettingsController.this.view).setSecondPlayerConfiguration(
                            (ContestSettingsDataObject) messageDataObject.getData()
                    );
                    break;
                case SETTINGS_IS_READY:
                    ((OnlineContestSettingsModel) ServerContestSettingsController.this.model).secondPlayerValidate();
                    ServerContestSettingsController.this.startContest();
                    break;
            }
        }
    }

    private void startContest() {
        if (((OnlineContestSettingsModel) this.model).canStartContest()) {
            this.settingsDataObject = ((ContestSettingsView) this.view).getSettingsDataObject();

            // check the validity of the settings dto
            if (false == ((OnlineContestSettingsModel) this.model).validateSettingsDataObject(this.settingsDataObject)) {
                String warningMessage = ((ContestSettingsModel) this.model).getInvalidDataObjectText();
                ((ContestSettingsView) this.view).updateWarningMessage(warningMessage);

                this.socketCommunicatorService.emit(new MessageDataObject(
                        MessageType.SETTINGS_WARNING_MESSAGE,
                        warningMessage
                ));

                ((OnlineContestSettingsModel) this.model).resetValidations();

                ((ContestSettingsView) this.view).resetReadyButton();

                return;
            }

            this.setChanged();
            this.notifyObservers(ActionEnum.START_CONTEST);
        }
    }
}
