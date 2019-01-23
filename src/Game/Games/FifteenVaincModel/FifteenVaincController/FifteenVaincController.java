package Game.Games.FifteenVaincModel.FifteenVaincController;

import Game.Controller.AbstractGameController;
import Game.Games.Coord;
import Game.Games.FifteenVaincModel.FifteenVaincModel.FifteenVaincModel;
import Game.Games.FifteenVaincModel.FifteenVaincView.FifteenVaincView;
import Game.Games.DataObject.PawnDataObject;
import Player.Player;

import java.util.Observable;

public class FifteenVaincController extends AbstractGameController {

    public FifteenVaincController(FifteenVaincModel m, FifteenVaincView v, boolean isTraining) {
        super(m, v, isTraining);
        Player currentPlayer = ((FifteenVaincModel) this.model).getCurrentPlayer();
        ((FifteenVaincView) this.view).updateCurrentPlayer(currentPlayer);
    }

    @Override
    public void update(Observable o, Object arg) {
        Coord coord = (Coord) arg;
        PawnDataObject pawnDataObject = ((FifteenVaincModel) this.model).play(coord);
        // Check if move is allowed
        if (null != pawnDataObject) {
            // Set pawn on view
            ((FifteenVaincView) this.view).setPawnView(
                    pawnDataObject.getValue(),
                    pawnDataObject.getColor(),
                    pawnDataObject.getCoord()
            );

            // Check if game is finished
            if (((FifteenVaincModel) this.model).isFinished()) {
                ((FifteenVaincModel) this.model).updatePlayerStats();
                if (!this.isTraining) {
                    ((FifteenVaincModel) this.model).sendStats();
                }
                this.setChanged();
                this.notifyObservers(((FifteenVaincModel) this.model).getWinner());
            } else {
                ((FifteenVaincModel) this.model).changePlayer();
                ((FifteenVaincView) this.view).changePlayer();
            }
        }
    }
}
