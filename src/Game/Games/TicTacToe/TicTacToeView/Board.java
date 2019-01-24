package Game.Games.TicTacToe.TicTacToeView;

import Game.Games.Coord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Board extends JLayeredPane {
    protected TicTacToeView parent;
    private Map<Coord, Box> map;
    private int size;

    public Board(int size, TicTacToeView parent) {
        super();
        this.map = new HashMap<Coord, Box>();
        this.parent = parent;
        this.size = size;
        this.setLayout(new GridLayout(this.size, this.size, 1, 1));
        Box box = null;
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                box = new Box(new Coord(i, j));
                this.add(box);
                this.map.put((box).getCoord(), box);
                box.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Board.this.parent.getObservable().notifyObservers(((Box) e.getSource()).getCoord());
                    }
                });
            }
        }
        this.revalidate();
        this.repaint();
    }

    public void setPawnBoard(String text, Color color, Coord coord) {
        map.get(coord).setPawn(text, color);
        this.revalidate();
        this.repaint();
    }
}
