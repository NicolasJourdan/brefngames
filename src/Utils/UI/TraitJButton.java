package Utils.UI;

import javax.swing.*;

public class TraitJButton {

    public static void traitSetSelected(JToggleButton button) {
        if (button instanceof JCheckBox) {
            button.setIcon(FileGetter.getImageIcon("_button06.png"));
            button.setSelectedIcon(FileGetter.getImageIcon("_button10.png"));
        }

        if (button instanceof JRadioButton) {
            button.setIcon(FileGetter.getImageIcon("_circle.png"));
            button.setSelectedIcon(FileGetter.getImageIcon("_boxTick.png"));
        }
    }
}
