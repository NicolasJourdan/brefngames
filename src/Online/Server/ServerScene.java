package Online.Server;

import Game.GameScene;
import Online.Server.Controller.ServerController;
import Online.Server.Model.ServerModel;
import Online.Server.View.ServerView;

import java.net.Socket;

public class ServerScene extends GameScene {
    public ServerScene() {
        this.model = new ServerModel();
        this.view = new ServerView();
        this.controller = new ServerController(this.model, this.view);
        this.controller.addObserver(this);
    }

    public Socket getSocket() {
        return ((ServerController) this.controller).getSocket();
    }
}
