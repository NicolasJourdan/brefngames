package Utils.UI;

import javax.swing.*;

public class CustomLabel extends JLabel {
    public CustomLabel(String text) {
        super(text);
        this.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_LABEL));
    }
}
