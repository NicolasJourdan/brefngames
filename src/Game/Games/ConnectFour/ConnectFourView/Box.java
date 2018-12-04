package Game.Games.ConnectFour.ConnectFourView;

import Game.Games.Coord;
import Parameter.Model.ThemeEnum;
import Repository.Parameter.ThemeParameterRepository;

import javax.swing.*;
import java.awt.*;


public class Box extends JButton {
    private final Coord coord;
    private Color backgroundColor;
    private Color emptyColor;
    private Color color;
    private Color borderColor;
    private Color opositeColor;

    public Box(Coord coord) {
        this.coord = coord;
        this.setPreferredSize(new Dimension(75, 75));
        this.setLayout(new BorderLayout());
        setOpaque(true);
        backgroundColor = (Color) ThemeParameterRepository.getColor(ThemeEnum.FIRST_COLOR).getValue();
        this.emptyColor = (Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue();
        this.color = (Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue();
        this.borderColor = (Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue();
        if(ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue().equals(Color.BLACK)){
            this.opositeColor = Color.WHITE;
        } else {
            this.opositeColor = Color.BLACK;
        }
    }

    @Override
    public void paint(Graphics g){
        g.setColor(this.backgroundColor);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(this.opositeColor);
        g.fillOval(-3, -3, this.getWidth(), this.getHeight());
        g.setColor(this.emptyColor);
        g.fillOval(0, 0, this.getWidth(), this.getHeight());
        g.setColor(this.borderColor);
        g.fillOval(5, 5, this.getWidth() - 6, this.getHeight() - 6);
        g.setColor(this.color);
        g.fillOval(3, 3, this.getWidth() - 6, this.getHeight() - 6);
        g.setColor(this.borderColor);
        g.fillOval(10, 10, this.getWidth() - 20, this.getHeight() - 20);
        g.setColor(this.color);
        g.fillOval(12, 12, this.getWidth() - 24, this.getHeight() - 24);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public void setPawn(Color color) {
        this.color = color;
        this.borderColor = opositeColor;
        this.revalidate();
        this.repaint();
    }

    public Coord getCoord() {
        return this.coord;
    }
}
