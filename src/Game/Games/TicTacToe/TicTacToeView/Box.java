package Game.Games.TicTacToe.TicTacToeView;

import javax.swing.*;
import java.awt.*;

public class Box extends JPanel {
    private final Coord coord;
    private Pawn pawn;

    public Box(Coord coord) {
        this.coord = coord;
        this.setLayout(new BorderLayout());

        setOpaque(false);
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);

    }

    public void setPawn(Pawn p){
        this.pawn = p;
    }

    public Pawn getPawn(){
        return this.pawn;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    public Coord getCoord() {
        // TODO Auto-generated method stub
        return this.coord;
    }


}