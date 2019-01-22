package Game.Games.Hangman.View;

import Parameter.Model.ThemeEnum;
import Repository.Parameter.ThemeParameterRepository;
import Utils.UI.FileGetter;
import Utils.UI.Utils;

import javax.swing.*;
import java.awt.*;


public class HangmanBox extends JButton {

    private static int BOX_SIZE = 50;
    private Color color;
    private Color backgroundColor;
    private Color borderColor;
    private Color opositeColor;
    private Color gradientColor;
    private String text;
    private Font font;

    public HangmanBox(String text, Dimension size) {
        this.text = text;
        this.setPreferredSize(size);
        this.setLayout(new BorderLayout());
        this.font = FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_TITLE_LABEL);
        setOpaque(true);
        this.borderColor = (Color) ThemeParameterRepository.getColor(ThemeEnum.FIRST_COLOR).getValue();
        this.backgroundColor = (Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue();
        this.color = this.borderColor;
        if (ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue().equals(Color.BLACK)) {
            this.opositeColor = Color.WHITE;
            this.gradientColor = Color.DARK_GRAY;
        } else {
            this.opositeColor = Color.BLACK;
            this.gradientColor = this.backgroundColor.darker();
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(this.borderColor);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(this.backgroundColor);
        GradientPaint gradient = new GradientPaint(50, 50, this.backgroundColor, this.getWidth(), this.getHeight(), this.gradientColor);
        ((Graphics2D) g).setPaint(gradient);
        g.fillRect(5, 5, this.getWidth() - 10, this.getHeight() - 10);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Dimension d = this.getSize();
        g2d.setColor(this.opositeColor);
        g2d.setFont(this.font);
        FontMetrics fm = g2d.getFontMetrics();
        int x = (d.width - fm.stringWidth(text)) / 2;
        int y = (d.height + fm.getAscent()) / 2 - ((int) (0.15 * Utils.DEFAULT_SIZE_TITLE_LABEL));
        g2d.drawString(this.text, x, y);
        g2d.setColor(color);
        x = x - 1;
        y = y - 1;
        g2d.drawString(this.text, x, y);
    }

    public void setDisabled() {
        this.color = this.backgroundColor;
        this.borderColor = this.backgroundColor;
        this.opositeColor = this.backgroundColor;
        this.revalidate();
        this.repaint();
    }

    @Override
    public String getText() {
        return text;
    }
}
