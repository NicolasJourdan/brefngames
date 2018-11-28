package Game.Games.TicTacToe.TicTacToeView;

import javax.swing.*;
import java.awt.*;

public class Box extends JButton {
    private static Color backgroundColor = Color.LIGHT_GRAY;
    private final Coord coord;
    private Color color;

    public Box(Coord coord) {
        this.coord = coord;
        this.setPreferredSize(new Dimension(150, 150));
        this.setLayout(new BorderLayout());
        this.setFont(new Font("myFont", Font.TRUETYPE_FONT, 250));
        setOpaque(true);
        color = Color.LIGHT_GRAY;
    }

    @Override
    public void paint(Graphics g){
        g.setColor(this.backgroundColor);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Dimension d = this.getSize();
        g2d.setColor(color);
        g2d.setFont(this.getFont());
        FontMetrics fm = g2d.getFontMetrics();
        String text = this.getText();
        int x = (d.width - fm.stringWidth(text)) / 2;
        int y = (d.height + fm.getAscent()) / 2 - 55;
        g2d.drawString(text, x, y);
    }

    public void setPawn(String text, Color color) {
        this.setText(text);
        this.color = color;
        this.revalidate();
        this.repaint();
    }

    public Coord getCoord() {
        // TODO Auto-generated method stub
        return this.coord;
    }


}