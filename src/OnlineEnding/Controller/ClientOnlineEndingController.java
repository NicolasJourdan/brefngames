package OnlineEnding.Controller;

import Online.Socket.Message.MessageDataObject;
import Online.Socket.Message.MessageType;
import Online.Socket.SocketCommunicatorService;
import OnlineEnding.View.OnlineEndingView;
import Scene.Model.ActionEnum;
import Structure.AbstractController;
import Structure.AbstractModel;
import Structure.AbstractView;

import java.util.Observable;

public class ClientOnlineEndingController extends AbstractController {

    private final SocketCommunicatorService socketCommunicatorService;

    public ClientOnlineEndingController(AbstractModel model, AbstractView view, SocketCommunicatorService socketCommunicatorService) {
        super(model, view);

        this.socketCommunicatorService = socketCommunicatorService;
    }

    @Override
    public void update(Observable o, Object action) {
        switch ((ActionEnum) action) {
            case ONLINE_ENDING_CONTINUE:
                ((OnlineEndingView) this.view).setWaitingButton();
                this.socketCommunicatorService.emit(new MessageDataObject(MessageType.CONTEST_ENDING_NEXT));
                break;
            case END_CONTEST:
                this.setChanged();
                this.notifyObservers(ActionEnum.END_ONLINE_CONTEST);
                break;
        }
    }
}
