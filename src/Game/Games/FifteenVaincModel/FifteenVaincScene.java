package Game.Games.FifteenVaincModel;

import Game.GameScene;
import Game.Games.FifteenVaincModel.FifteenVaincController.FifteenVaincController;
import Game.Games.FifteenVaincModel.FifteenVaincModel.FifteenVaincModel;
import Game.Games.FifteenVaincModel.FifteenVaincView.FifteenVaincView;
import Player.Player;

public class FifteenVaincScene extends GameScene{
    private final static int DEFAULT_SIZE_ROW = 1;
    private final static int DEFAULT_SIZE_COLUMN = 9;

    public FifteenVaincScene(Player[] listPlayers, boolean isTraining, int[] scores) {
        this.model = new FifteenVaincModel(listPlayers);
        this.view = new FifteenVaincView(DEFAULT_SIZE_ROW, DEFAULT_SIZE_COLUMN, listPlayers, scores);
        this.controller = new FifteenVaincController((FifteenVaincModel) this.model, (FifteenVaincView) this.view, isTraining);
        this.controller.addObserver(this);
    }
}
