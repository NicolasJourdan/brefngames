package Utils.UI;

import Parameter.Model.ThemeEnum;
import Repository.Parameter.ThemeParameterRepository;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomTextField extends JTextField {

    private final static int WIDTH = 190;
    private final static int HEIGHT = 49;
    private final static int BORDER = 11;
    // tested value so the text doesn't go outside the borders
    private final static int COLUMNS = 14;

    private final Image backgroundImage;

    /**
     * The number of columns is forced by the const COLUMNS in order to have a correct width
     *
     * @param text
     */
    public CustomTextField(String text) {
        this(text, CustomTextField.COLUMNS);
    }

        /**
         * The number of columns is forced by the const COLUMNS in order to have a correct width
         *
         * @param text
         * @param columns
         */
    private CustomTextField(String text, int columns) {
        super(text, COLUMNS);

        this.setForeground((Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue());
        this.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_LABEL));
        this.setBorder(new EmptyBorder(0, CustomTextField.BORDER, 0, CustomTextField.BORDER));
        this.setOpaque(false);

        this.backgroundImage = FileGetter.getImageIcon("_button13.png").getImage();
        this.setPreferredSize(new Dimension(CustomTextField.WIDTH, CustomTextField.HEIGHT));

        this.revalidate();
        this.repaint();

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                CustomTextField.this.playSound();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.backgroundImage, 0, 0, this);

        // at the end for the background image to be under the text
        super.paint(g);
    }

    private void playSound() {
        SoundPlayer.playSound(Utils.DEFAULT_CLICK_SOUND);
    }
}
