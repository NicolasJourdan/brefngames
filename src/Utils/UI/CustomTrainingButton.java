package Utils.UI;

import Utils.Image.ImageResizer;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

public class CustomTrainingButton extends JButton
{
    private final static int BUTTON_WIDTH = 200;
    private final static int BUTTON_HEIGHT = 200;
    private final static int WIDTH = 120;
    private final static int HEIGHT = 120;
    private final static int Y_OFFSET = 4;

    private Image backgroundImage;
    private int yOffset;

    public CustomTrainingButton(String imageIconPath) {
        Border emptyBorder = BorderFactory.createEmptyBorder();
        this.setBorder(emptyBorder);
        this.setPreferredSize(new Dimension(CustomTrainingButton.BUTTON_WIDTH, CustomTrainingButton.BUTTON_HEIGHT));

        ImageIcon imageIcon = new ImageIcon(ImageIcon.class.getResource("/data/Images/" + imageIconPath));
        this.backgroundImage = ImageResizer.resizeImage(imageIcon, CustomTrainingButton.WIDTH, CustomTrainingButton.HEIGHT).getImage();

        this.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if ( CustomTrainingButton.this.model.isPressed()) {
                     CustomTrainingButton.this.playSound();
                     CustomTrainingButton.this.setBackgroundPressed();
                }
                else {
                     CustomTrainingButton.this.setBackgroundNormal();
                }

                 CustomTrainingButton.this.revalidate();
                 CustomTrainingButton.this.repaint();
            }
        });

        this.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                 CustomTrainingButton.this.setBackgroundNormal();
                 CustomTrainingButton.this.revalidate();
                 CustomTrainingButton.this.repaint();
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
        g2d.drawImage(
                this.backgroundImage,
                (CustomTrainingButton.BUTTON_WIDTH - this.backgroundImage.getWidth(null)) / 2,
                ((CustomTrainingButton.BUTTON_HEIGHT - this.backgroundImage.getHeight(null)) / 2) + this.yOffset,
                this
        );

        g2d.finalize();
    }

    private void setBackgroundNormal() {
        this.yOffset = 0;
    }

    private void setBackgroundPressed() {
        this.yOffset = CustomTrainingButton.Y_OFFSET;
    }
}
