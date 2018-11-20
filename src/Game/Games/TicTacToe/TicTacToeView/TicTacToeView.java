package Game.Games.TicTacToe.TicTacToeView;

import Game.View.AbstractGameView;

import javax.swing.*;
import java.awt.*;

public class TicTacToeView extends AbstractGameView {
    private Board board;
    private int size;

    public TicTacToeView() {
        JFrame frame = new JFrame();
        Dimension dim;
        dim = new Dimension(1000, 800);
        this.board = new Board();
        frame.setTitle("Jeu d'échec");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(400, 10);
        frame.setPreferredSize(dim);
        frame.pack();
        frame.setResizable(true);
        frame.setVisible(true);
    }


}
