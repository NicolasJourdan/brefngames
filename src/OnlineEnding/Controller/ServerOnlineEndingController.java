package OnlineEnding.Controller;

import Contest.Interface.SocketObserverController;
import Online.Socket.Message.MessageDataObject;
import Online.Socket.SocketCommunicatorService;
import OnlineEnding.Model.ServerOnlineEndingModel;
import OnlineEnding.View.OnlineEndingView;
import Scene.Model.ActionEnum;
import Structure.AbstractController;
import Structure.AbstractModel;
import Structure.AbstractView;

import java.util.Observable;
import java.util.Observer;

public class ServerOnlineEndingController extends AbstractController implements SocketObserverController {

    private final SocketCommunicatorService socketCommunicatorService;
    private final SocketReceptionObserver socketReceptionObserver;

    public ServerOnlineEndingController(AbstractModel model, AbstractView view, SocketCommunicatorService socketCommunicatorService) {
        super(model, view);

        this.socketCommunicatorService = socketCommunicatorService;
        this.socketReceptionObserver = new SocketReceptionObserver();
        this.socketCommunicatorService.addReceptionObserver(this.socketReceptionObserver);
    }

    @Override
    public void update(Observable o, Object action) {
        switch ((ActionEnum) action) {
            case ONLINE_ENDING_CONTINUE:
                ((OnlineEndingView) this.view).setWaitingButton();
                ((ServerOnlineEndingModel) this.model).localPlayerContinue();
                this.next();
                break;
            case END_CONTEST:
                this.setChanged();
                this.notifyObservers(ActionEnum.END_ONLINE_CONTEST);
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
                case CONTEST_ENDING_NEXT:
                    ((ServerOnlineEndingModel) ServerOnlineEndingController.this.model).onlinePlayerContinue();
                    ServerOnlineEndingController.this.next();
                    break;
            }
        }
    }

    private void next() {
        if (((ServerOnlineEndingModel) this.model).shouldContinue()) {
            this.setChanged();
            this.notifyObservers(ActionEnum.ONLINE_ENDING_START_NEW_CONTEST);
        }
    }
}
