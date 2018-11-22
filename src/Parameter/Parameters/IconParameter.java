package Parameter.Parameters;

import javax.swing.*;

public class IconParameter extends AbstractParameter {

    private String name;
    public IconParameter(ImageIcon imageIcon, String name) {
        this.value = imageIcon;
        this.name = name;
    }

    public static ImageIcon getImageFromString(String name) {
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

    public String getName() {
        return this.name;
    }
}
