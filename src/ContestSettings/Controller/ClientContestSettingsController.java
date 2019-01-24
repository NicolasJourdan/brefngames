package ContestSettings.Controller;

import Contest.Interface.SocketObserverController;
import ContestSettings.DataObject.ContestSettingsDataObject;
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

public class ClientContestSettingsController extends AbstractController implements SocketObserverController {

    private final SocketCommunicatorService socketCommunicatorService;
    private final SocketReceptionObserver socketReceptionObserver;

    public ClientContestSettingsController(AbstractModel model, AbstractView view, SocketCommunicatorService socketCommunicatorService) {
        super(model, view);

        this.socketCommunicatorService = socketCommunicatorService;
        this.socketReceptionObserver = new SocketReceptionObserver();
        this.socketCommunicatorService.addReceptionObserver(this.socketReceptionObserver);

        ((ContestSettingsView) this.view).setOnlineMode(false);
        ((ContestSettingsView) this.view).registerDataChangeListener(false);
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
                ((ContestSettingsView) this.view).readyButtonSetWaiting();

                this.socketCommunicatorService.emit(new MessageDataObject(MessageType.SETTINGS_IS_READY));
                break;
        }
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
                case SETTINGS_DEFAULT_VALUES:
                    ((ContestSettingsView) ClientContestSettingsController.this.view).setDefaultConfiguration(
                            (Map<ParameterEnum, Configurable>) messageDataObject.getData()
                    );
                    break;
                case SETTINGS_VALUES_CHANGED:
                    ((ContestSettingsView) ClientContestSettingsController.this.view).setFirstPlayerConfiguration(
                            (ContestSettingsDataObject) messageDataObject.getData()
                    );
                    break;
                case SETTINGS_WARNING_MESSAGE:
                    ((ContestSettingsView) ClientContestSettingsController.this.view).updateWarningMessage(
                            (String) messageDataObject.getData()
                    );
                    ((ContestSettingsView) ClientContestSettingsController.this.view).resetReadyButton();
                    break;
            }
        }
    }
}
