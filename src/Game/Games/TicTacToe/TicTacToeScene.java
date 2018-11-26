package Game.Games.TicTacToe;

import Game.GameScene;
import Game.Games.TicTacToe.TicTacToeController.TicTacToeController;
import Player.Player;
import Game.Games.TicTacToe.TicTacToeModel.TicTacToeModel;
import Game.Games.TicTacToe.TicTacToeView.TicTacToeView;

public class TicTacToeScene extends GameScene {
    private final static int DEFAULT_SIZE = 3;

    public TicTacToeScene(Player[] listPlayers) {
        this.model = new TicTacToeModel(listPlayers, DEFAULT_SIZE);
        this.view = new TicTacToeView(DEFAULT_SIZE);
        this.controller = new TicTacToeController((TicTacToeModel) this.model, (TicTacToeView) this.view, DEFAULT_SIZE);
        this.controller.addObserver(this);
    }
}
