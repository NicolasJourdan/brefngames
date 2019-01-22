package Game.Games.ConnectFour.ConnectFourController;

import Game.Controller.AbstractGameController;
import Game.Games.ConnectFour.ConnectFourModel.ConnectFourModel;
import Game.Games.ConnectFour.ConnectFourView.ConnectFourView;
import Game.Games.Coord;
import Game.Games.DataObject.PawnDataObject;
import Player.Player;

import java.util.Observable;

public class ConnectFourController extends AbstractGameController {

    public ConnectFourController(ConnectFourModel m, ConnectFourView v, boolean isTraining) {
        super(m, v, isTraining);
        Player currentPlayer = ((ConnectFourModel) this.model).getCurrentPlayer();
        ((ConnectFourView) this.view).updateCurrentPlayer(currentPlayer);
    }

    @Override
    public void update(Observable o, Object arg) {
        Coord coord = (Coord) arg;
        PawnDataObject pawnDataObject = ((ConnectFourModel) this.model).play(coord);
        if (null != pawnDataObject) {
            // Set pawn on view
            ((ConnectFourView) this.view).setPawnView(
                    pawnDataObject.getColor(),
                    pawnDataObject.getCoord()
            );

            // Check if game is finished
            if (((ConnectFourModel) this.model).isFinished()) {
                ((ConnectFourModel) this.model).updatePlayerStats();
                if (!this.isTraining) {
                    ((ConnectFourModel) this.model).sendStats(
                            ((ConnectFourModel) this.model).getOrientation()
                    );
                }
                this.setChanged();
                this.notifyObservers(((ConnectFourModel) this.model).getWinner());
            } else {
                ((ConnectFourView) this.view).changePlayer();
            }
        }
    }
}
