package Game.Games.TicTacToe;

import Game.Games.TicTacToe.TicTacToeModel.TTTPlayer;
import Game.Games.TicTacToe.TicTacToeModel.TicTacToeModel;
import Game.Games.TicTacToe.TicTacToeView.TicTacToeView;
import Scene.Model.Scene;

public class TicTacToeScene extends Scene {

    private static TTTPlayer player1 = new TTTPlayer("NicoLeBg", "Blue");
    private static TTTPlayer player2 = new TTTPlayer("RayaneLaMenace", "Red");
    private static TTTPlayer[] listPlayers = {player1, player2};

    public TicTacToeScene() {
        this.model = new TicTacToeModel(listPlayers);
        this.view = new TicTacToeView();
        this.controller = new TicTacToeController((TicTacToeModel) this.model, (TicTacToeView) this.view);
        this.controller.addObserver(this);

    }
}
