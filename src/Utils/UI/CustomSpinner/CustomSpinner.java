package Utils.UI.CustomSpinner;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class CustomSpinner extends JSpinner {

    public CustomSpinner(SpinnerModel model) {
        super(model);

        final CustomSpinnerEditor editor = new CustomSpinnerEditor(((Integer) model.getValue()).toString());
        this.setEditor(editor);
        this.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                editor.setText(((Integer) CustomSpinner.this.getValue()).toString());
            }
        });

        this.setBorder(BorderFactory.createEmptyBorder());

        this.setUI(new CustomSpinnerUI());
    }

    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg);


        int n = this.getComponentCount();
        for (int i = 0; i < n; i++) {
            Component c = this.getComponent(i);
            c.setForeground(fg);
        }
    }
}
