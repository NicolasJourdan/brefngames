package Game.Games.TicTacToe.TicTacToeView;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Board extends JLayeredPane {
    Map<Coord, Box> map = new HashMap<Coord, Box>();
    int size = 3;
    public Board() {
        this.setLayout(new GridLayout(this.size, this.size));
        for (int i = 0; i<this.size; i++){
            for (int j = 0;j<this.size;j++){
                Box box;
                Coord coord = new Coord (i, j);
                box = new Box(coord);
                this.add(box);
                map.put((box).getCoord(), box);
            }
        }
    }
}
