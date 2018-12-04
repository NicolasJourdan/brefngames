package Utils.UI;

import Parameter.Factory.ColorFactory;
import Parameter.Model.ThemeEnum;
import Repository.Parameter.ThemeParameterRepository;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class FileGetter {
    private final static String UI_PATH = "/data/UIpack/";

    /**
     * Get a resource from the UIpack
     *
     * @param resourcePath
     * @return
     */
    public static URL getResource(String resourcePath) {
        return FileGetter.class.getResource(FileGetter.UI_PATH + '/' + resourcePath);
    }

    /**
     * Get an image from the UIpack
     *
     * @param imagePath
     * @return
     */
    public static Image getImage(String imagePath) {
        return FileGetter.getImageIcon(imagePath).getImage();
    }

    public static ImageIcon getImageIcon(String imagePath) {
        return new ImageIcon(FileGetter.getResource("PNG/" + FileGetter.getColor() + imagePath));
    }

    /**
     * Get a font from the UIpag
     * @return
     */
    public static Font getFont() {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File("src/" + FileGetter.UI_PATH + "/Font/kenvector_future_thin.ttf"));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new JLabel().getFont();
    }

    /**
     * Get color from parameters
     *
     * @return
     */
    private static String getColor() {
        Color color = (Color) ThemeParameterRepository.getColor(ThemeEnum.FIRST_COLOR).getValue();
        return ColorFactory.getStringColor(color).toLowerCase();
    }
}
