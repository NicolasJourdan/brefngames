package Map.Controller;

import Contest.Interface.SocketObserverController;
import Game.Model.AbstractGameModel;
import Game.View.AbstractGameView;
import Map.Model.History;
import Map.View.MapView;
import Online.Socket.Message.MessageDataObject;
import Online.Socket.Message.MessageType;
import Online.Socket.SocketCommunicatorService;
import Scene.Model.ActionEnum;

import java.util.Observable;
import java.util.Observer;

public class ClientMapController extends MapController implements SocketObserverController {

    private static final String BACK_BUTTON_TEXT = "next";

    private final SocketCommunicatorService socketCommunicatorService;
    private final SocketReceptionService socketReceptionService;


    public ClientMapController(AbstractGameModel model, AbstractGameView view, History history, SocketCommunicatorService socketCommunicatorService) {
        super(model, view, history);

        this.socketCommunicatorService = socketCommunicatorService;
        this.socketReceptionService = new SocketReceptionService();
        this.socketCommunicatorService.addReceptionObserver(this.socketReceptionService);
    }

    @Override
    public void update(Observable o, Object action) {
        switch ((ActionEnum) action) {
            case END_MAP:
                ((MapView) this.view).setWaitingButton();
                this.socketCommunicatorService.emit(new MessageDataObject(MessageType.MAP_NEXT));
                break;
        }
    }

    @Override
    public void stopObserver() {
        this.socketCommunicatorService.deleteReceptionObserver(this.socketReceptionService);
    }

    private class SocketReceptionService implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            MessageDataObject messageDataObject = (MessageDataObject) arg;

            switch (messageDataObject.getType()) {
                case MAP_FINISH:
                    ((MapView) ClientMapController.this.view).setBackButton(ClientMapController.BACK_BUTTON_TEXT);
                    break;
            }
        }
    }
}
