package Utils.UI;

import javax.swing.*;

public class CustomRadioButton extends JRadioButton {
    public CustomRadioButton(String text) {
        super(text);
        TraitJButton.traitSetSelected(this);
        this.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_BUTTON_TEXT));
    }
}
