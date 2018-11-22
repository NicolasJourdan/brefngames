package Game.Games.TicTacToe.TicTacToeView;

import Game.View.AbstractGameView;
import Structure.ProxyObservable;

public class TicTacToeView extends AbstractGameView {
    private Board board;
    private int size;

    public TicTacToeView(int size) {
        this.size = size;
        this.board = new Board(this.size);
        this.add(this.board);
    }

    public ProxyObservable getObservable(){
        return this.observable;
    }

}
