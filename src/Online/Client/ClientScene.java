package Online.Client;

import Game.GameScene;
import Online.Client.Controller.ClientController;
import Online.Client.Model.ClientModel;
import Online.Client.View.ClientView;

public class ClientScene extends GameScene {
    public ClientScene() {
        this.model = new ClientModel();
        this.view = new ClientView();
        this.controller = new ClientController(this.model, this.view);
        this.controller.addObserver(this);
    }
}
