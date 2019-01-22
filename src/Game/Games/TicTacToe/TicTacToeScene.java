package Game.Games.TicTacToe;

import Game.GameScene;
import Game.Games.TicTacToe.TicTacToeController.TicTacToeController;
import Game.Games.TicTacToe.TicTacToeModel.TicTacToeModel;
import Game.Games.TicTacToe.TicTacToeView.TicTacToeView;
import Player.Player;

public class TicTacToeScene extends GameScene {
    private final static int DEFAULT_SIZE = 3;

    public TicTacToeScene(Player[] listPlayers, boolean isTraining, int[] scores) {
        this.model = new TicTacToeModel(listPlayers, DEFAULT_SIZE);
        this.view = new TicTacToeView(DEFAULT_SIZE, listPlayers, scores);
        this.controller = new TicTacToeController((TicTacToeModel) this.model, (TicTacToeView) this.view, DEFAULT_SIZE, isTraining);
        this.controller.addObserver(this);
    }
}
