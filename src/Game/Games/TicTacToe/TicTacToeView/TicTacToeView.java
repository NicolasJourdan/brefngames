package Game.Games.TicTacToe.TicTacToeView;

import javax.swing.*;
import java.awt.*;

public class TicTacToeView extends JFrame{
    Board board;
    int size;

    public TicTacToeView() {
        JFrame frame;
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
