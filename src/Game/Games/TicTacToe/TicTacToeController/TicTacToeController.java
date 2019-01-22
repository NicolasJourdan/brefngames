package Game.Games.TicTacToe.TicTacToeController;

import Game.Controller.AbstractGameController;
import Game.Games.Coord;
import Game.Games.TicTacToe.DataObject.PawnDataObject;
import Game.Games.TicTacToe.TicTacToeModel.TicTacToeModel;
import Game.Games.TicTacToe.TicTacToeView.TicTacToeView;
import Player.Player;

import java.util.Observable;

public class TicTacToeController extends AbstractGameController {

    public TicTacToeController(TicTacToeModel m, TicTacToeView v, boolean isTraining) {
        super(m, v, isTraining);
        Player currentPlayer = ((TicTacToeModel) this.model).getCurrentPlayer();
        ((TicTacToeView) this.view).updateCurrentPlayer(currentPlayer);
    }

    @Override
    public void update(Observable o, Object arg) {
        Coord coord = (Coord) arg;
        PawnDataObject pawnDataObject = ((TicTacToeModel) this.model).play(coord);
        // Check if move is allowed
        if (null != pawnDataObject) {
            // Set pawn on view
            ((TicTacToeView) this.view).setPawnView(
                    pawnDataObject.getValue(),
                    pawnDataObject.getColor(),
                    pawnDataObject.getCoord()
            );

            // Check if game is finished
            if (((TicTacToeModel) this.model).isFinished()) {
                ((TicTacToeModel) this.model).updatePlayerStats();
                if (!this.isTraining) {
                    ((TicTacToeModel) this.model).sendStats();
                }
                this.setChanged();
                this.notifyObservers(((TicTacToeModel) this.model).getWinner());
            } else {
                ((TicTacToeModel) this.model).changePlayer();
                ((TicTacToeView) this.view).changePlayer();
            }
        }
    }
}
