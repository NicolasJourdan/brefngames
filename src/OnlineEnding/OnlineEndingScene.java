package OnlineEnding;

import Game.GameScene;
import Online.Socket.SocketCommunicatorService;
import OnlineEnding.Controller.ClientOnlineEndingController;
import OnlineEnding.Controller.ServerOnlineEndingController;
import OnlineEnding.Model.ClientOnlineEndingModel;
import OnlineEnding.Model.ServerOnlineEndingModel;
import OnlineEnding.View.OnlineEndingView;

public class OnlineEndingScene extends GameScene {

    public OnlineEndingScene(boolean isServer, SocketCommunicatorService socketCommunicatorService) {
        this.model = isServer ?
                new ServerOnlineEndingModel() :
                new ClientOnlineEndingModel();
        this.view = new OnlineEndingView();
        this.controller = isServer ?
                new ServerOnlineEndingController(this.model, this.view, socketCommunicatorService) :
                new ClientOnlineEndingController(this.model, this.view, socketCommunicatorService)
        ;
        this.controller.addObserver(this);
    }

}
