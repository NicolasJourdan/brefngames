package Game.Games.ConnectFour.ConnectFourView;

import Game.Games.Coord;
import Game.View.AbstractGameView;
import Structure.ProxyObservable;

import java.awt.*;

public class ConnectFourView extends AbstractGameView {
    private Board board;
    private int size;

    public ConnectFourView(int rows, int columns) {
        this.size = size;
        this.board = new Board(rows, columns, this);
        this.add(this.board);
    }

    public void setPawnView(Color color, Coord coord) {
        this.board.setPawnBoard(color, coord);
        this.revalidate();
        this.repaint();
    }

    public ProxyObservable getObservable() {
        return this.observable;
    }
}
