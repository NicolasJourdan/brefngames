package Game.Games.ConnectFour.ConnectFourView;

import Game.Games.Coord;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Board extends JLayeredPane {
    protected ConnectFourView parent;
    private Map<Coord, Box> map = new HashMap<Coord, Box>();

    public Board(int rows, int columns, ConnectFourView parent) {
        super();
        this.parent = parent;
        this.setLayout(new GridLayout(rows, columns, 3, 3));
        Box box = null;
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < columns; i++) {
                box = new Box(new Coord(i, j));
                this.add(box);
                map.put((box).getCoord(), box);
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

    public void setPawnBoard(Color color, Coord coord) {
        map.get(coord).setPawn(color);
        this.revalidate();
        this.repaint();
    }
}
