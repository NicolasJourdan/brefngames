package Utils.UI;

import javax.swing.*;

public class TraitJButton {

    public static void traitSetSelected(JToggleButton button) {
        button.setIcon(FileGetter.getImageIcon("_circle.png"));
        button.setSelectedIcon(FileGetter.getImageIcon("_boxTick.png"));
    }
}
