package Game.Games.TicTacToe.TicTacToeView;

import Game.View.AbstractGameView;
import Structure.ProxyObservable;

import javax.swing.*;
import java.awt.*;

public class TicTacToeView extends AbstractGameView {
    private Board board;
    private int size;

    public TicTacToeView(int size) {
        this.size = size;
        this.board = new Board(this.size, this);
        this.add(this.board);
    }

    public void displayMessage(String text){
        JOptionPane.showMessageDialog(this, text);
    }

    public void setPawnView(String text, Color color, Coord coord){
        this.board.setPawnBoard(text, color, coord);
        this.revalidate();
        this.repaint();
    }

    public ProxyObservable getObservable(){
        return this.observable;
    }

}
