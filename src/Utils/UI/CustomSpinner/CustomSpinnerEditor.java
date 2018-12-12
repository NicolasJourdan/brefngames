package Utils.UI.CustomSpinner;

import Parameter.Model.ThemeEnum;
import Repository.Parameter.ThemeParameterRepository;
import Utils.UI.FileGetter;
import Utils.UI.SoundPlayer;
import Utils.UI.Utils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class CustomSpinnerEditor extends JTextField {

    public final static int WIDTH = 190;
    public final static int HEIGHT = 49;
    public final static int BORDER = 11;

    private final static int COLUMNS = 2;

    private final Image backgroundImage;

    public CustomSpinnerEditor(String text) {
        super(text, CustomSpinnerEditor.COLUMNS);

        this.setForeground((Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue());
        this.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_LABEL));
        this.setBorder(new EmptyBorder(0, CustomSpinnerEditor.BORDER, 0, CustomSpinnerEditor.BORDER));
        this.setOpaque(false);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setEditable(false);

        this.backgroundImage = FileGetter.getImageIcon("_button13.png").getImage();
        this.setPreferredSize(new Dimension(CustomSpinnerEditor.WIDTH, CustomSpinnerEditor.HEIGHT));

        this.revalidate();
        this.repaint();

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                CustomSpinnerEditor.this.playSound();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

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
                CustomSpinnerEditor.BORDER,
                CustomSpinnerEditor.HEIGHT
        );
        g2d.drawImage(
                leftBorder,
                0,
                0,
                this
        );

        // right border
        BufferedImage rightBorder = bufferedImage.getSubimage(
                CustomSpinnerEditor.WIDTH - CustomSpinnerEditor.BORDER,
                0,
                CustomSpinnerEditor.BORDER,
                CustomSpinnerEditor.HEIGHT
        );
        g2d.drawImage(
                rightBorder,
                this.getWidth() - CustomSpinnerEditor.BORDER,
                0,
                this
        );

        // section
        BufferedImage section = bufferedImage.getSubimage(
                CustomSpinnerEditor.BORDER,
                0,
                1,
                CustomSpinnerEditor.HEIGHT
        );
        g2d.drawImage(
                section,
                CustomSpinnerEditor.BORDER,
                0,
                this.getWidth() - (2 * CustomSpinnerEditor.BORDER),
                this.getHeight(),
                this
        );

        // at the end for the background image to be under the text
        super.paint(g);
    }

    private void playSound() {
        SoundPlayer.playSound(Utils.DEFAULT_CLICK_SOUND);
    }
}
