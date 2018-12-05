package Utils.UI;

import javax.swing.*;

public class CustomCheckBox extends JCheckBox {
    public CustomCheckBox(String string) {
        super(string);
        TraitJButton.traitSetSelected(this);
        this.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_BUTTON_TEXT));
    }
}
