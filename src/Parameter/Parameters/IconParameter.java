package Parameter.Parameters;

import javax.swing.*;

public class IconParameter extends AbstractParameter {

    private String name;
    public IconParameter(ImageIcon imageIcon, String name) {
        this.value = imageIcon;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
