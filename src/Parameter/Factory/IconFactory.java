package Parameter.Factory;

import javax.swing.*;

public class IconFactory {

    public static ImageIcon getIcon(String name) {
        switch (name) {
            case "BATMAN_1":
            case "BATMAN_2":
                return new ImageIcon("data/Images/batman.png");
            case "SUPERMAN_1":
            case "SUPERMAN_2":
                return new ImageIcon("data/Images/superman.png");
            case "FLASH_1":
            case "FLASH_2":
                return new ImageIcon("data/Images/flash.png");
            case "AQUAMAN_1":
            case "AQUAMAN_2":
                return new ImageIcon("data/Images/aquaman.png");
            default:
                throw new RuntimeException("The image : " + name + " is unknown");
        }

    }
}
