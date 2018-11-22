package Game.Games.TicTacToe;

import Game.GameScene;
import Game.Games.TicTacToe.TicTacToeController.TicTacToeController;
import Game.Games.TicTacToe.TicTacToeModel.TTTPlayer;
import Game.Games.TicTacToe.TicTacToeModel.TicTacToeModel;
import Game.Games.TicTacToe.TicTacToeView.TicTacToeView;

public class TicTacToeScene extends GameScene {

    private static TTTPlayer player1 = new TTTPlayer("NicoLeBg", "Blue");
    private static TTTPlayer player2 = new TTTPlayer("RayaneLaMenace", "Red");
    private static TTTPlayer[] listPlayers = {player1, player2};
    private static int size = 3;

    public TicTacToeScene() {
        this.model = new TicTacToeModel(listPlayers, this.size);
        this.view = new TicTacToeView(this.size);
        this.controller = new TicTacToeController((TicTacToeModel) this.model, (TicTacToeView) this.view, this.size);
        this.controller.addObserver(this);

    }
}
