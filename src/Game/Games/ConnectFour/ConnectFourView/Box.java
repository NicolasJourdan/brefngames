package Game.Games.ConnectFour.ConnectFourView;

import Game.Games.Coord;

import javax.swing.*;
import java.awt.*;


public class Box extends JButton {
    private static final Color DEFAULT_BACKGROUND_COLOR = Color.LIGHT_GRAY;
    private final Coord coord;
    private Color color;

    public Box(Coord coord) {
        this.coord = coord;
        this.setPreferredSize(new Dimension(75, 75));
        this.setLayout(new BorderLayout());
        setOpaque(true);
        this.color = DEFAULT_BACKGROUND_COLOR;
    }

    @Override
    public void paint(Graphics g){
        g.setColor(DEFAULT_BACKGROUND_COLOR);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(this.color);
        g.fillOval(0, 0, this.getWidth(), this.getHeight());
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public void setPawn(Color color) {
        this.color = color;
        this.revalidate();
        this.repaint();
    }

    public Coord getCoord() {
        return this.coord;
    }
}
