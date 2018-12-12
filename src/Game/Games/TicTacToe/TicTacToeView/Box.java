package Game.Games.TicTacToe.TicTacToeView;

import Game.Games.Coord;
import Parameter.Model.ThemeEnum;
import Repository.Parameter.ThemeParameterRepository;

import javax.swing.*;
import java.awt.*;


public class Box extends JButton {
    private static final Color DEFAULT_GRADIENT_COLOR = Color.GRAY;
    private final Coord coord;
    private Color color;
    private Color backgroundColor;
    private Color borderColor;
    private Color opositeColor;
    private Color gradientColor;

    public Box(Coord coord) {
        this.coord = coord;
        this.setPreferredSize(new Dimension(150, 150));
        this.setLayout(new BorderLayout());
        this.setFont(new Font("myFont", Font.PLAIN, 250));
        setOpaque(true);
        this.borderColor = (Color) ThemeParameterRepository.getColor(ThemeEnum.FIRST_COLOR).getValue();
        this.backgroundColor = (Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue();
        this.color = this.backgroundColor;
        if(ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue().equals(Color.BLACK)){
            this.opositeColor = Color.WHITE;
            this.gradientColor = Color.DARK_GRAY;
        } else {
            this.opositeColor = Color.BLACK;
            this.gradientColor = this.backgroundColor.darker();
        }
    }

    @Override
    public void paint(Graphics g){
        g.setColor(this.borderColor);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(this.backgroundColor);
        GradientPaint gradient = new GradientPaint(50, 50, this.backgroundColor, this.getWidth(), this.getHeight(), this.gradientColor);
        ((Graphics2D) g).setPaint(gradient);
        g.fillRect(5, 5, this.getWidth()-10, this.getHeight()-10);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Dimension d = this.getSize();
        g2d.setColor(this.opositeColor);
        g2d.setFont(this.getFont());
        FontMetrics fm = g2d.getFontMetrics();
        String text = this.getText();
        int x = (d.width - fm.stringWidth(text)) / 2;
        int y = (d.height + fm.getAscent()) / 2 - 55;
        g2d.drawString(text, x, y);
        g2d.setColor(color);
        x = x - 5;
        y = y - 5;
        g2d.drawString(text, x, y);
    }

    public void setPawn(String text, Color color) {
        this.setText(text);
        this.color = color;
        this.revalidate();
        this.repaint();
    }

    public Coord getCoord() {
        return this.coord;
    }
}
