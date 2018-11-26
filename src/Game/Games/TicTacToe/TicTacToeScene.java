package Game.Games.TicTacToe;

import Game.GameScene;
import Game.Games.TicTacToe.TicTacToeController.TicTacToeController;
import Player.Player;
import Game.Games.TicTacToe.TicTacToeModel.TicTacToeModel;
import Game.Games.TicTacToe.TicTacToeView.TicTacToeView;

public class TicTacToeScene extends GameScene {
    private static int size = 3;

    public TicTacToeScene(Player[] listPlayers) {
        this.model = new TicTacToeModel(listPlayers, this.size);
        this.view = new TicTacToeView(this.size);
        this.controller = new TicTacToeController((TicTacToeModel) this.model, (TicTacToeView) this.view, this.size);
        this.controller.addObserver(this);

    }
}
