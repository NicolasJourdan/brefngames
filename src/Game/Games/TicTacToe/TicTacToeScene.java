package Game.Games.TicTacToe;

import Game.GameScene;
import Game.Games.TicTacToe.TicTacToeController.TicTacToeController;
import Game.Games.TicTacToe.TicTacToeModel.TicTacToeModel;
import Game.Games.TicTacToe.TicTacToeView.TicTacToeView;
import Player.Player;

public class TicTacToeScene extends GameScene {
    public TicTacToeScene(Player[] listPlayers, boolean isTraining, int[] scores) {
        this.model = new TicTacToeModel(listPlayers);
        this.view = new TicTacToeView(listPlayers, scores);
        this.controller = new TicTacToeController((TicTacToeModel) this.model, (TicTacToeView) this.view, isTraining);
        this.controller.addObserver(this);
    }
}
