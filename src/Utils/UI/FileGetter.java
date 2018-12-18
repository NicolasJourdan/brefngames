package Utils.UI;

import Parameter.Factory.ColorFactory;
import Parameter.Model.ThemeEnum;
import Repository.Parameter.ThemeParameterRepository;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class FileGetter {
    private final static String UI_PATH = "/src/data/UIpack/";

    /**
     * Get a resource from the UIpack
     *
     * @param resourcePath
     * @return
     */
    public static String getResource(String resourcePath) {
        return new File(".").getAbsolutePath() + FileGetter.UI_PATH + resourcePath;
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
     * Get a grey image from the UIpack
     * @param imagePath
     * @return
     */
    public static Image getGreyImage(String imagePath) {
        return FileGetter.getGreyImageIcon(imagePath).getImage();
    }

    public static ImageIcon getGreyImageIcon(String imagePath) {
        return new ImageIcon(FileGetter.getResource("PNG/grey" + imagePath));
    }

    /**
     * Get a font from the UIpag
     * @return
     */
    public static Font getFont() {

        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File(new File(".").getAbsolutePath() + FileGetter.UI_PATH + "/Font/kenvector_future_thin.ttf"));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new JLabel().getFont();
    }

    /**
     * Get a sound for the UIpack
     *
     * @param sound
     * @return
     */
    public static File getSound(String sound) {
        return new File(new File(".").getAbsolutePath() + FileGetter.UI_PATH + "Bonus/" + sound);
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
