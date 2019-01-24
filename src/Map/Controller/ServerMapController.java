package Map.Controller;

import Contest.Interface.SocketObserverController;
import Game.Model.AbstractGameModel;
import Game.View.AbstractGameView;
import Map.Model.History;
import Map.Model.OnlineMapModel;
import Map.View.MapView;
import Online.Socket.Message.MessageDataObject;
import Online.Socket.Message.MessageType;
import Online.Socket.SocketCommunicatorService;
import Scene.Model.ActionEnum;

import java.util.Observable;
import java.util.Observer;

public class ServerMapController extends MapController implements SocketObserverController {

    public static final String BACK_BUTTON_TEXT = "next";
    private final SocketCommunicatorService socketCommunicatorService;
    private final SocketReceptionService socketReceptionService;

    public ServerMapController(AbstractGameModel model, AbstractGameView view, History history, SocketCommunicatorService socketCommunicatorService) {
        super(model, view, history);

        this.socketCommunicatorService = socketCommunicatorService;
        this.socketReceptionService = new SocketReceptionService();
        this.socketCommunicatorService.addReceptionObserver(this.socketReceptionService);
        if (this.isTraining || ((OnlineMapModel) this.model).isFinish(this.history)) {
            this.socketCommunicatorService.emit(new MessageDataObject(MessageType.MAP_FINISH));
        }
    }

    @Override
    public void update(Observable o, Object action) {
        switch ((ActionEnum) action) {
            case END_MAP:
                ((OnlineMapModel) this.model).firstPlayerValidate();
                ((MapView) this.view).setWaitingButton();
                this.next();
                break;
        }
    }

    private void next() {
        if (((OnlineMapModel) this.model).canStartScene()) {
            this.setChanged();
            this.notifyObservers(ActionEnum.END_MAP);
        }
    }

    @Override
    public void stopObserver() {
        this.socketCommunicatorService.deleteReceptionObserver(this.socketReceptionService);
    }

    @Override
    protected void setBackButton() {
        if (this.isTraining || ((OnlineMapModel) this.model).isFinish(this.history)) {
            ((MapView) this.view).setBackButton(ServerMapController.BACK_BUTTON_TEXT);
        }
    }

    private class SocketReceptionService implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            MessageDataObject messageDataObject = (MessageDataObject) arg;

            switch (messageDataObject.getType()) {
                case MAP_NEXT:
                    ((OnlineMapModel) ServerMapController.this.model).secondPlayerValidate();
                    ServerMapController.this.next();
                    break;
            }
        }
    }
}
