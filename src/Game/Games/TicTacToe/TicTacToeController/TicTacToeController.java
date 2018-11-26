package Game.Games.TicTacToe.TicTacToeController;

import Game.Controller.AbstractGameController;
import Game.Games.TicTacToe.TicTacToeModel.*;
import Game.Games.TicTacToe.TicTacToeView.Coord;
import Game.Games.TicTacToe.TicTacToeView.TicTacToeView;
import Scene.Model.ActionEnum;

import java.awt.*;
import java.util.Observable;

public class TicTacToeController extends AbstractGameController {
    private int size;


    public TicTacToeController(TicTacToeModel m, TicTacToeView v, int size) {
        super(m, v);
        this.size = size;
    }

    @Override
    public void update(Observable o, Object arg) {
        Coord coord = (Coord) arg;
        String status = ((TicTacToeModel) this.model).setPawnModel(coord);
        if (status != null) {
            Color color = ((TicTacToeModel) this.model).getCurrentPlayer().getColor();
            ((TicTacToeView) this.view).setPawnView(status, color, coord);
            if (((TicTacToeModel) this.model).isWinner()) {
                this.setChanged();
                if (((TicTacToeModel) this.model).getCurrentPlayer().getName().equals(((TicTacToeModel) this.model).getPlayers()[0])) {
                    this.notifyObservers(ActionEnum.PLAYER_1_WON);
                } else {
                    this.notifyObservers(ActionEnum.PLAYER_2_WON);
                }
            }
            if (((TicTacToeModel) this.model).isDraw()) {
                this.setChanged();
                this.notifyObservers(ActionEnum.DRAW);
            }
            ((TicTacToeModel) this.model).changePlayer();
        }
    }
}
