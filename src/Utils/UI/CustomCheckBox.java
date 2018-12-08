package Utils.UI;

import Parameter.Model.ThemeEnum;
import Repository.Parameter.ThemeParameterRepository;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CustomCheckBox extends JCheckBox {

    private final static int WIDTH = 49;
    private final static int HEIGHT = 49;
    private final static int TEXT_GAP = 10;
    private final static int Y_OFFSET = 4;

    private Image backgroundImage;
    private int yOffset;

    public CustomCheckBox(String text) {
        super(text);

        Font font = FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_BUTTON_TEXT);
        this.setFont(font);
        FontMetrics fontMetrics = this.getFontMetrics(font);

        this.setPreferredSize(
                new Dimension(
                        CustomCheckBox.WIDTH + CustomCheckBox.TEXT_GAP + fontMetrics.stringWidth(text),
                        CustomCheckBox.HEIGHT
                )
        );
        this.updateBackground();

        this.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (CustomCheckBox.this.model.isPressed()) {
                    CustomCheckBox.this.playSound();
                }
            }
        });

        this.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                CustomCheckBox.this.updateBackground();
            }
        });
    }

    private void playSound() {
        SoundPlayer.playSound(Utils.DEFAULT_CLICK_SOUND);
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

        // checkbox image
        g2d.drawImage(
                this.backgroundImage,
                0,
                this.yOffset,
                this
        );


        // text
        g2d.setFont(this.getFont());
        g2d.setColor((Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue());
        FontMetrics fontMetrics = g.getFontMetrics();
        g2d.drawString(
                this.getText(),
                CustomCheckBox.WIDTH + CustomCheckBox.TEXT_GAP,
                ((this.getHeight() - fontMetrics.getHeight()) / 2) + fontMetrics.getAscent() + CustomCheckBox.Y_OFFSET
        );

        g2d.finalize();
    }
}
