package Map.View;

import Player.Player;
import Structure.AbstractView;

import javax.swing.*;
import java.awt.*;

public class MapView extends AbstractView {

    public MapView() {
        super();
        this.setLayout(new GridLayout(1, 10));
    }

    public void addGame(Player winner, String gameName) {
        JPanel current = new JPanel();
        current.setLayout(new GridLayout(3, 1));
        if (null == winner) {
            current.add(new JLabel("Match null"));
            current.add(new JLabel("Match null"));
        } else {
        }

    }
}
