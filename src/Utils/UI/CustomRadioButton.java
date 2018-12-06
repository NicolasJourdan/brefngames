package Utils.UI;

import javax.swing.*;

public class CustomRadioButton extends JRadioButton {
    public CustomRadioButton(String text) {
        super(text);

        this.setIcon(FileGetter.getImageIcon("_circle.png"));
        this.setSelectedIcon(FileGetter.getImageIcon("_boxTick.png"));

        this.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_BUTTON_TEXT));
    }
}
