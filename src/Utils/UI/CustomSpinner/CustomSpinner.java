package Utils.UI.CustomSpinner;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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

        this.setUI(new CustomSpinnerUI());
    }
}
