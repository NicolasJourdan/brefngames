package Utils.UI.CustomeComboBox;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

public class CustomComboBoxUI extends BasicComboBoxUI {
    @Override
    protected ComboPopup createPopup() {
        BasicComboPopup b = new BasicComboPopup(this.comboBox);
        b.setBorder(BorderFactory.createEmptyBorder());
        return b;
    }

    @Override
    protected JButton createArrowButton() {
        return new JButton() {
            @Override
            public int getWidth() {
                return 0;
            }
        };
    }
}
