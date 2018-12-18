package Utils.UI.CustomComboBox;

import Parameter.Model.ThemeEnum;
import Repository.Parameter.ThemeParameterRepository;
import Utils.UI.FileGetter;
import Utils.UI.Utils;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;

public class CustomComboBoxRenderer extends BasicComboBoxRenderer {

    private Image backgroundImage;
    private Font font;
    private final static int RENDERER_WIDTH = 145;
    private final static int RENDERER_HEIGHT = 45;
    private final static int IMAGE_WIDTH = 190;
    private final static int IMAGE_HEIGHT = 45;

    public CustomComboBoxRenderer() {
        super();

        this.setPreferredSize(new Dimension(CustomComboBoxRenderer.RENDERER_WIDTH, CustomComboBoxRenderer.RENDERER_HEIGHT));
        this.font = FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_BUTTON_TEXT);
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (-1 == index) {
            this.backgroundImage = FileGetter.getImage("_button_arrow.png");
        } else if (isSelected) {
            this.backgroundImage = FileGetter.getImage("_button_unfilled.png");
        } else {
            this.backgroundImage = FileGetter.getImage("_button_rectangle.png");
        }

        return this;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // background image
        g2d.drawImage(this.backgroundImage, 0, 0, this);

        // text
        g2d.setFont(this.font);
        g2d.setColor((Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue());
        FontMetrics fontMetrics = g.getFontMetrics(this.font);
        g2d.drawString(
                this.getText(),
                (CustomComboBoxRenderer.IMAGE_WIDTH - fontMetrics.stringWidth(this.getText())) / 2,
                ((CustomComboBoxRenderer.IMAGE_HEIGHT - fontMetrics.getHeight()) / 2) + fontMetrics.getAscent()
        );

        g2d.finalize();
    }
}
