package Map.Controller;

import Game.Model.AbstractGameModel;
import Game.View.AbstractGameView;
import Map.Model.History;
import Map.View.MapView;
import Online.Socket.Message.MessageDataObject;
import Online.Socket.Message.MessageType;
import Online.Socket.SocketCommunicatorService;
import Scene.Model.ActionEnum;

import java.util.Observable;

public class ClientMapController extends MapController {

    private final SocketCommunicatorService socketCommunicatorService;

    public ClientMapController(AbstractGameModel model, AbstractGameView view, History history, SocketCommunicatorService socketCommunicatorService) {
        super(model, view, history);
        this.socketCommunicatorService = socketCommunicatorService;

        ((MapView) this.view).setContinueButton();
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
}
