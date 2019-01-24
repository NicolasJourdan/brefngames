package Online.Client;

import Game.GameScene;
import Online.Client.Controller.ClientController;
import Online.Client.Model.ClientModel;
import Online.Client.View.ClientView;

import java.net.Socket;

public class ClientScene extends GameScene {
    public ClientScene() {
        this.model = new ClientModel();
        this.view = new ClientView();
        this.controller = new ClientController(this.model, this.view);
        this.controller.addObserver(this);
    }

    public Socket getSocket() {
        return ((ClientController) this.controller).getSocket();
    }
}
