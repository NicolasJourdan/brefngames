package Utils.Image;

import javax.swing.*;
import java.awt.*;

public class ImageResizer {

    /**
     * Scale an ImageIcon
     *
     * @param image
     * @param width
     * @param height
     * @return the scaled image
     */
    public static ImageIcon resizeImage(ImageIcon image, int width, int height) {
        return new ImageIcon(
            image.getImage().getScaledInstance(
                width,
                height,
                Image.SCALE_SMOOTH
            )
        );
    }

    /**
     * Scale an ImageIcon
     *
     * @param image
     * @param size
     * @return the scaled image
     */
    public static ImageIcon resizeImage(ImageIcon image, int size) {
        return ImageResizer.resizeImage(image, size, size);
    }
}
