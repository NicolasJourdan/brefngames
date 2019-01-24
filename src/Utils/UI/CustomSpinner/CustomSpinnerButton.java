package Utils.UI.CustomSpinner;

import Parameter.Factory.ColorFactory;
import Parameter.Model.ThemeEnum;
import Repository.Parameter.ThemeParameterRepository;
import Utils.UI.CustomCheckBox;
import Utils.UI.FileGetter;
import Utils.UI.SoundPlayer;
import Utils.UI.Utils;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class CustomSpinnerButton extends JButton {

    private static final String BACKGROUND_COLOR = "#EEEEEE";

    public final static int WIDTH = 36;
    public final static int HEIGHT = 36;

    private Image backgroundImage;

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

    @Override
    public void setEnabled(boolean b) {
        super.setEnabled(b);
        this.backgroundImage = b ? FileGetter.getImageIcon("_circle.png").getImage() :
                FileGetter.getGreyImageIcon("_circle.png").getImage();
        this.revalidate();
        this.repaint();
    }

    private void playSound() {
        SoundPlayer.playSound(Utils.DEFAULT_CLICK_SOUND);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // clear background
        g2d.setColor(Color.decode(CustomSpinnerButton.BACKGROUND_COLOR));
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

        // background image
        g2d.drawImage(this.backgroundImage, 0, 0, this);

        // text
        g2d.setFont(this.getFont());
        g2d.setColor(this.isEnabled() ? this.getForeground() : Color.GRAY);
        FontMetrics fontMetrics = g.getFontMetrics(this.getFont());
        g2d.drawString(
                this.getText(),
                (CustomSpinnerButton.WIDTH - fontMetrics.stringWidth(this.getText())) / 2,
                ((CustomSpinnerButton.HEIGHT- fontMetrics.getHeight()) / 2) + fontMetrics.getAscent()
        );

        g2d.finalize();
    }
}
