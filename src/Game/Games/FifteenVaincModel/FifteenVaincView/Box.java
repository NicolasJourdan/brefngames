package Game.Games.FifteenVaincModel.FifteenVaincView;

import Game.Games.Coord;
import Parameter.Model.ThemeEnum;
import Repository.Parameter.ThemeParameterRepository;
import Utils.UI.FileGetter;
import Utils.UI.Utils;

import javax.swing.*;
import java.awt.*;

public class Box extends JButton {
    private static int BOX_SIZE = 50;
    private final Coord coord;
    private Color color;
    private Color backgroundColor;
    private Color borderColor;
    private Color opositeColor;
    private Color gradientColor;
    private Font font;

    public Box(Coord coord) {
        this.coord = coord;
        this.font = FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_TITLE_LABEL);
        this.setPreferredSize(new Dimension(BOX_SIZE, BOX_SIZE));
        this.setLayout(new BorderLayout());
        setOpaque(true);
        this.borderColor = (Color) ThemeParameterRepository.getColor(ThemeEnum.FIRST_COLOR).getValue();
        this.backgroundColor = (Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue();
        if(ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue().equals(Color.BLACK)){
            this.opositeColor = Color.WHITE;
            this.gradientColor = Color.DARK_GRAY;
        } else {
            this.opositeColor = Color.BLACK;
            this.gradientColor = this.backgroundColor.darker();
        }
        this.color = this.opositeColor;
        this.revalidate();
        this.repaint();
    }

    @Override
    public void paint(Graphics g){
        // Box Contour
        g.setColor(this.borderColor);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Box background
        g.setColor(this.backgroundColor);
        GradientPaint gradient = new GradientPaint(10, 10, this.backgroundColor, this.getWidth(), this.getHeight(), this.gradientColor);
        ((Graphics2D) g).setPaint(gradient);
        g.fillRect(5, 5, this.getWidth()-10, this.getHeight()-10);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Dimension d = this.getSize();

        // Text
        FontMetrics fm = g2d.getFontMetrics();
        String text = String.valueOf(this.coord.getY()+1);
        int x = (d.width - fm.stringWidth(text)) / 2;
        int y = (d.height + fm.getAscent()) / 2;
        g2d.setFont(this.font);
        g2d.setColor(this.color);
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
