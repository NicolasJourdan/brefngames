package Game.Games.ConnectFour;

import Game.GameScene;
import Game.Games.ConnectFour.ConnectFourController.ClientConnectFourController;
import Game.Games.ConnectFour.ConnectFourController.ConnectFourController;
import Game.Games.ConnectFour.ConnectFourController.ServerConnectFourController;
import Game.Games.ConnectFour.ConnectFourModel.ConnectFourModel;
import Game.Games.ConnectFour.ConnectFourView.ConnectFourView;
import Online.Socket.SocketCommunicatorService;
import Player.Player;

public class ConnectFourScene extends GameScene {

    public ConnectFourScene(Player[] listPlayers, boolean isTraining, int[] scores) {
        this.model = new ConnectFourModel(listPlayers);
        this.view = new ConnectFourView(listPlayers, scores);
        this.controller = new ConnectFourController((ConnectFourModel) this.model, (ConnectFourView) this.view, isTraining);
        this.controller.addObserver(this);
    }

    public ConnectFourScene(Player[] listPlayers, boolean isTraining, int[] scores, boolean isServer, SocketCommunicatorService socketCommunicatorService) {
        this.model = new ConnectFourModel(listPlayers);
        this.view = new ConnectFourView(listPlayers, scores);
        this.controller = isServer ?
                new ServerConnectFourController((ConnectFourModel) this.model, (ConnectFourView) this.view, isTraining, socketCommunicatorService) :
                new ClientConnectFourController((ConnectFourModel) this.model, (ConnectFourView) this.view, isTraining, socketCommunicatorService)
        ;
        this.controller.addObserver(this);
    }
}
