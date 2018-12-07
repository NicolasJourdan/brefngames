package Utils.UI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class CustomCheckBox extends JCheckBox {

    private final static int WIDTH = 49;
    private final static int HEIGHT = 49;
    private final static int Y_OFFSET = 4;

    private Image backgroundImage;
    private int yOffset;

    public CustomCheckBox(String string) {
        super(string);

        this.setPreferredSize(new Dimension(CustomCheckBox.WIDTH, CustomCheckBox.HEIGHT));
        this.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_BUTTON_TEXT));
        this.updateBackground();

        this.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                CustomCheckBox.this.updateBackground();
            }
        });
    }

    private void updateBackground() {
        if (this.isSelected()) {
            this.yOffset = CustomCheckBox.Y_OFFSET;
            this.backgroundImage = FileGetter.getImage("_button10.png");
        }
        else {
            this.yOffset = 0;
            this.backgroundImage = FileGetter.getImage("_button06.png");
        }

        this.revalidate();
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(
                this.backgroundImage,
                0,
                this.yOffset,
                this
        );
    }
}
