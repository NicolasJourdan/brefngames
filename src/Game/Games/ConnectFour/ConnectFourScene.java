package Game.Games.ConnectFour;

import Game.GameScene;
import Game.Games.ConnectFour.ConnectFourController.ConnectFourController;
import Game.Games.ConnectFour.ConnectFourModel.ConnectFourModel;
import Game.Games.ConnectFour.ConnectFourView.ConnectFourView;
import Player.Player;

public class ConnectFourScene extends GameScene {

    public ConnectFourScene(Player[] listPlayers, boolean isTraining, int[] scores) {
        this.model = new ConnectFourModel(listPlayers);
        this.view = new ConnectFourView(listPlayers, scores);
        this.controller = new ConnectFourController((ConnectFourModel) this.model, (ConnectFourView) this.view, isTraining);
        this.controller.addObserver(this);
    }
}
