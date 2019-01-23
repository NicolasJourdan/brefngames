package Map.Controller;

import Game.Model.AbstractGameModel;
import Game.View.AbstractGameView;
import Map.Model.History;
import Map.Model.OnlineMapModel;
import Map.View.MapView;
import Online.Socket.Message.MessageDataObject;
import Online.Socket.SocketCommunicatorService;
import Scene.Model.ActionEnum;

import java.util.Observable;
import java.util.Observer;

public class ServerMapController extends MapController {

    private final SocketCommunicatorService socketCommunicatorService;

    public ServerMapController(AbstractGameModel model, AbstractGameView view, History history, SocketCommunicatorService socketCommunicatorService) {
        super(model, view, history);

        this.socketCommunicatorService = socketCommunicatorService;
        this.socketCommunicatorService.addReceptionObserver(new SocketReceptionService());
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
