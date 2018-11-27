package Parameter.Factory;

import javax.swing.*;

public class IconFactory {

    public static ImageIcon getIcon(String name) {
        switch (name) {
            case "BATMAN":
            case "BATMAN_1":
            case "BATMAN_2":
                return new ImageIcon(ImageIcon.class.getResource("/data/Images/batman.png"), "BATMAN");
            case "SUPERMAN":
            case "SUPERMAN_1":
            case "SUPERMAN_2":
                return new ImageIcon(ImageIcon.class.getResource("/data/Images/superman.png"), "SUPERMAN");
            case "FLASH":
            case "FLASH_1":
            case "FLASH_2":
                return new ImageIcon(ImageIcon.class.getResource("/data/Images/flash.png"), "FLASH");
            case "AQUAMAN":
            case "AQUAMAN_1":
            case "AQUAMAN_2":
                return new ImageIcon(ImageIcon.class.getResource("/data/Images/aquaman.png"), "AQUAMAN");
            default:
                throw new RuntimeException("The image : " + name + " is unknown");
        }
    }

    public static String getStringIcon(ImageIcon icon) {
        return icon.getDescription();
    }
}
