package Utils.UI;

import Parameter.Model.ThemeEnum;
import Repository.Parameter.ThemeParameterRepository;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

public class CustomButton extends JButton {

    private final static int WIDTH = 190;
    private final static int HEIGHT = 49;
    private final static int Y_OFFSET = 4;

    private Font font;
    private Image backgroundImage;
    private int yOffset;

    public CustomButton(String text) {
        super(text);

        Border emptyBorder = BorderFactory.createEmptyBorder();
        this.setBorder(emptyBorder);
        this.setBackgroundNormal();
        this.setPreferredSize(new Dimension(CustomButton.WIDTH, CustomButton.HEIGHT));

        this.font = FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_BUTTON_TEXT);

        this.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (CustomButton.this.model.isPressed()) {
                    CustomButton.this.playSound();
                    CustomButton.this.setBackgroundPressed();
                }
                else {
                    CustomButton.this.setBackgroundNormal();
                }

                CustomButton.this.revalidate();
                CustomButton.this.repaint();
            }
        });

        this.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomButton.this.setBackgroundOver();
                CustomButton.this.revalidate();
                CustomButton.this.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomButton.this.setBackgroundNormal();
                CustomButton.this.revalidate();
                CustomButton.this.repaint();
            }
        });
    }

    private void playSound() {
        SoundPlayer.playSound(Utils.DEFAULT_CLICK_SOUND);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // background image
        g2d.drawImage(this.backgroundImage, 0, this.yOffset, this);

        // text
        g2d.setFont(this.font);
        g2d.setColor((Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue());
        FontMetrics fontMetrics = g.getFontMetrics(this.font);
        g2d.drawString(
                this.getText(),
                (this.getWidth() - fontMetrics.stringWidth(this.getText())) / 2,
                ((this.getHeight() - fontMetrics.getHeight()) / 2) + fontMetrics.getAscent() + this.yOffset
        );

        g2d.finalize();
    }

    private void setBackgroundNormal() {
        this.yOffset = 0;
        this.backgroundImage = FileGetter.getImage("_button00.png");
    }

    private void setBackgroundOver() {
        this.yOffset = 0;
        this.backgroundImage = FileGetter.getImage("_button02.png");
    }

    private void setBackgroundPressed() {
        this.yOffset = CustomButton.Y_OFFSET;
        this.backgroundImage = FileGetter.getImage("_button01.png");
    }
}
