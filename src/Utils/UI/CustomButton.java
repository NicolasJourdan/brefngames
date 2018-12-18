package Utils.UI;

import Parameter.Factory.ColorFactory;
import Parameter.Model.ThemeEnum;
import Repository.Parameter.ThemeParameterRepository;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class CustomButton extends JButton {

    private final static int WIDTH = 190;
    private final static int HEIGHT = 49;
    private final static int Y_OFFSET = 4;
    private static final int BORDER_WIDTH = 5;

    private Font font;
    private Image backgroundImage;
    private int yOffset;

    public CustomButton(String text) {
        this(text, CustomButton.WIDTH);
    }

    public CustomButton(String text, int width) {
        super(text);

        Border emptyBorder = BorderFactory.createEmptyBorder();
        this.setBorder(emptyBorder);
        this.setBackgroundNormal();
        this.setPreferredSize(new Dimension(width, CustomButton.HEIGHT));

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
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // clear background
        g2d.setColor(ColorFactory.getBackgroundColor((Color) ThemeParameterRepository.getColor(ThemeEnum.FIRST_COLOR).getValue()));
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

        // background image

        // Create a buffered image
        BufferedImage bufferedImage = new BufferedImage(
                this.backgroundImage.getWidth(null),
                this.backgroundImage.getHeight(null),
                BufferedImage.TYPE_INT_ARGB
        );
        // draw image on buffered image
        Graphics2D bGr = bufferedImage.createGraphics();
        bGr.drawImage(this.backgroundImage, 0, 0, null);
        bGr.dispose();

        // left border
        BufferedImage leftBorder = bufferedImage.getSubimage(
                0,
                0,
                CustomButton.BORDER_WIDTH,
                CustomButton.HEIGHT - this.yOffset
        );
        g2d.drawImage(
                leftBorder,
                0,
                this.yOffset,
                this
        );

        // right border
        BufferedImage rightBorder = bufferedImage.getSubimage(
                CustomButton.WIDTH - CustomButton.BORDER_WIDTH,
                0,
                CustomButton.BORDER_WIDTH,
                CustomButton.HEIGHT - this.yOffset
        );
        g2d.drawImage(
                rightBorder,
                this.getWidth() - CustomButton.BORDER_WIDTH,
                this.yOffset,
                this
        );

        // section
        BufferedImage section = bufferedImage.getSubimage(
                CustomButton.BORDER_WIDTH,
                0,
                1,
                CustomButton.HEIGHT - this.yOffset
        );
        g2d.drawImage(
                section,
                CustomButton.BORDER_WIDTH,
                this.yOffset,
                this.getWidth() - (2 * CustomButton.BORDER_WIDTH),
                CustomButton.HEIGHT - this.yOffset,
                this
        );

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
