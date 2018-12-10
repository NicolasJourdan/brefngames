package Game.Games.TicTacToe.TicTacToeView;

import Game.Games.Coord;
import Game.View.AbstractGameView;
import Player.Player;
import Structure.ProxyObservable;

import java.awt.*;

public class TicTacToeView extends AbstractGameView {
    private DisplayPanel firstPlayerDisplay;
    private Board board;
    private DisplayPanel secondPlayerDisplay;
    private int size;

    public TicTacToeView(int size, Player[] players) {
        this.size = size;
        this.setLayout(new GridLayout(1, 3, 0, 0));
        this.firstPlayerDisplay = new DisplayPanel(players[0], false);
        this.board = new Board(this.size, this);
        this.secondPlayerDisplay = new DisplayPanel(players[1], false);
        this.add(this.firstPlayerDisplay);
        this.add(this.board);
        this.add(this.secondPlayerDisplay);
        this.revalidate();
        this.repaint();
    }

    public void setPawnView(String text, Color color, Coord coord) {
        this.board.setPawnBoard(text, color, coord);
        this.revalidate();
        this.repaint();
    }

    public ProxyObservable getObservable() {
        return this.observable;
    }
}
