package Utils.UI.CustomSpinner;

import Utils.UI.FileGetter;
import Utils.UI.SoundPlayer;
import Utils.UI.Utils;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class CustomSpinnerButton extends JButton {

    public final static int WIDTH = 36;
    public final static int HEIGHT = 36;

    private final Image backgroundImage;

    public CustomSpinnerButton(String text) {
        super(text);

        this.setBorder(BorderFactory.createEmptyBorder());
        this.setPreferredSize(new Dimension(CustomSpinnerButton.WIDTH, CustomSpinnerButton.HEIGHT));
        this.backgroundImage = FileGetter.getImageIcon("_circle.png").getImage();
        this.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_BUTTON_TEXT));

        this.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (CustomSpinnerButton.this.model.isPressed()) {
                    CustomSpinnerButton.this.playSound();
                }
            }
        });
    }

    private void playSound() {
        SoundPlayer.playSound(Utils.DEFAULT_CLICK_SOUND);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // background image
        g2d.drawImage(this.backgroundImage, 0, 0, this);

        super.paintComponent(g);
    }
}
