package Game.Games.FifteenVaincModel.FifteenVaincView;

import Game.Games.Coord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Board extends JLayeredPane {
    protected FifteenVaincView parent;
    private Map<Coord, Box> map;
    private int row;
    private int column;

    public Board(int row, int column, FifteenVaincView parent) {
        super();
        this.map = new HashMap<Coord, Box>();
        this.parent = parent;
        this.row = row;
        this.column = column;
        this.setLayout(new GridLayout(this.row, this.column, 1,1));
        Box box = null;
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
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
