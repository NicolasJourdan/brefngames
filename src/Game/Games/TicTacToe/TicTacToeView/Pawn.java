package Game.Games.TicTacToe.TicTacToeView;

import javax.swing.*;

public class Pawn extends JButton {
    Coord coord;


    public Pawn(int x, int y) {
        this.coord = new Coord(x, y);
    }
}
