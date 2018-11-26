package Game.Games.TicTacToe.TicTacToeView;

import javax.swing.*;
import java.awt.*;

public class Box extends JButton {
    private final Coord coord;

    public Box(Coord coord) {
        this.coord = coord;
        this.setPreferredSize(new Dimension(150, 150));
        this.setLayout(new BorderLayout());

        setOpaque(true);
        setBackground(Color.LIGHT_GRAY);
        setForeground(Color.BLACK);

    }

    public void setPawn(String text, Color color) {
        this.setText(text);
        this.setBackground(color);
        this.revalidate();
        this.repaint();
    }

    public Coord getCoord() {
        // TODO Auto-generated method stub
        return this.coord;
    }


}