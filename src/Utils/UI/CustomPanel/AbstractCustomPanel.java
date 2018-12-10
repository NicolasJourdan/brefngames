package Utils.UI.CustomPanel;

import Utils.UI.FileGetter;
import Utils.UI.Utils;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;

public class AbstractCustomPanel extends JPanel {

    private static final int IMAGE_WIDTH = 100;
    private static final int IMAGE_HEIGHT = 100;
    private static final int BORDER_WIDTH = 5;

    private Image backgroundImage;

    public AbstractCustomPanel() {
        super();

        Border emptyBorder = BorderFactory.createEmptyBorder();
        this.setBorder(emptyBorder);
        this.setBackgroundImage(FileGetter.getImage("_panel.png"));

        this.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_LABEL));
    }

    // should be called in class extending this one
    protected void setBackgroundImage(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
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

        // top left corner
        this.drawImagePart(
                g2d, bufferedImage,
                0, 0,
                AbstractCustomPanel.BORDER_WIDTH, AbstractCustomPanel.BORDER_WIDTH,
                0, 0
        );

        // top right corner
        this.drawImagePart(
                g2d, bufferedImage,
                AbstractCustomPanel.IMAGE_WIDTH - AbstractCustomPanel.BORDER_WIDTH, 0,
                AbstractCustomPanel.BORDER_WIDTH, AbstractCustomPanel.BORDER_WIDTH,
                this.getWidth() - AbstractCustomPanel.BORDER_WIDTH, 0
        );

        // bottom left corner
        this.drawImagePart(
                g2d, bufferedImage,
                0, AbstractCustomPanel.IMAGE_HEIGHT - AbstractCustomPanel.BORDER_WIDTH,
                AbstractCustomPanel.BORDER_WIDTH, AbstractCustomPanel.BORDER_WIDTH,
                0, this.getHeight() - AbstractCustomPanel.BORDER_WIDTH
        );

        // bottom right corner
        this.drawImagePart(
                g2d, bufferedImage,
                AbstractCustomPanel.IMAGE_WIDTH - AbstractCustomPanel.BORDER_WIDTH, AbstractCustomPanel.IMAGE_HEIGHT - AbstractCustomPanel.BORDER_WIDTH,
                AbstractCustomPanel.BORDER_WIDTH, AbstractCustomPanel.BORDER_WIDTH,
                this.getWidth() - AbstractCustomPanel.BORDER_WIDTH, this.getHeight() - AbstractCustomPanel.BORDER_WIDTH
        );

        // top border
        this.drawImagePart(
                g2d, bufferedImage,
                AbstractCustomPanel.BORDER_WIDTH, 0,
                1, AbstractCustomPanel.BORDER_WIDTH,
                AbstractCustomPanel.BORDER_WIDTH, 0,
                this.getWidth() - AbstractCustomPanel.BORDER_WIDTH * 2, AbstractCustomPanel.BORDER_WIDTH
        );

        // right border
        this.drawImagePart(
                g2d, bufferedImage,
                AbstractCustomPanel.IMAGE_WIDTH - AbstractCustomPanel.BORDER_WIDTH, AbstractCustomPanel.BORDER_WIDTH,
                AbstractCustomPanel.BORDER_WIDTH, 1,
                this.getWidth() - AbstractCustomPanel.BORDER_WIDTH, AbstractCustomPanel.BORDER_WIDTH,
                AbstractCustomPanel.BORDER_WIDTH, this.getHeight() - AbstractCustomPanel.BORDER_WIDTH * 2
        );

        // bottom border
        this.drawImagePart(
                g2d, bufferedImage,
                AbstractCustomPanel.BORDER_WIDTH, AbstractCustomPanel.IMAGE_HEIGHT - AbstractCustomPanel.BORDER_WIDTH,
                1, AbstractCustomPanel.BORDER_WIDTH,
                AbstractCustomPanel.BORDER_WIDTH, this.getHeight() - AbstractCustomPanel.BORDER_WIDTH,
                this.getWidth() - AbstractCustomPanel.BORDER_WIDTH * 2, AbstractCustomPanel.BORDER_WIDTH
        );

        // left border
        this.drawImagePart(
                g2d, bufferedImage,
                0, AbstractCustomPanel.BORDER_WIDTH,
                AbstractCustomPanel.BORDER_WIDTH, 1,
                0, AbstractCustomPanel.BORDER_WIDTH,
                AbstractCustomPanel.BORDER_WIDTH, this.getHeight() - AbstractCustomPanel.BORDER_WIDTH * 2
        );

        // background
        this.drawImagePart(
                g2d, bufferedImage,
                AbstractCustomPanel.BORDER_WIDTH, AbstractCustomPanel.BORDER_WIDTH,
                1, 1,
                AbstractCustomPanel.BORDER_WIDTH, AbstractCustomPanel.BORDER_WIDTH,
                this.getWidth() - 2 * AbstractCustomPanel.BORDER_WIDTH, this.getHeight() - 2 * AbstractCustomPanel.BORDER_WIDTH
        );
    }

    private void drawImagePart(Graphics2D g2d, BufferedImage bufferedImage, int originX, int originY, int originWidth, int originHeight, int destinationX, int destinationY) {
        BufferedImage imagePart = bufferedImage.getSubimage(
                originX,
                originY,
                originWidth,
                originHeight
        );
        g2d.drawImage(
                imagePart,
                destinationX,
                destinationY,
                this
        );
    }


    private void drawImagePart(Graphics2D g2d, BufferedImage bufferedImage, int originX, int originY, int originWidth, int originHeight, int destinationX, int destinationY, int destinationWidth, int destinationHeight) {
        BufferedImage imagePart = bufferedImage.getSubimage(
                originX,
                originY,
                originWidth,
                originHeight
        );
        g2d.drawImage(
                imagePart,
                destinationX,
                destinationY,
                destinationWidth,
                destinationHeight,
                this
        );
    }
}
