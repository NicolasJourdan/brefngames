package Utils.UI.CustomSpinner;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSpinnerUI;
import java.awt.*;

public class CustomSpinnerUI extends BasicSpinnerUI {

    private static final int HORIZONTAL_PADDING = 5;

    @Override
    protected Component createPreviousButton() {
        JButton button = new CustomSpinnerButton("-");
        this.installPreviousButtonListeners(button);
        return button;
    }

    @Override
    protected Component createNextButton() {
        JButton button = new CustomSpinnerButton("+");
        this.installNextButtonListeners(button);
        return button;
    }


    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        c.removeAll();

        c.setLayout(new GridBagLayout());

        // reusable GridBagConstraint to place every needed components
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.fill = GridBagConstraints.BOTH;

        Insets buttonInsets = new Insets(
                (CustomSpinnerEditor.HEIGHT - CustomSpinnerButton.HEIGHT) / 2,
                CustomSpinnerUI.HORIZONTAL_PADDING,
                (CustomSpinnerEditor.HEIGHT - CustomSpinnerButton.HEIGHT) / 2,
                CustomSpinnerUI.HORIZONTAL_PADDING
        );
        Insets editorInsets = new Insets(0, CustomSpinnerUI.HORIZONTAL_PADDING, 0, CustomSpinnerUI.HORIZONTAL_PADDING);
        constraint.insets = buttonInsets;

        c.add(this.createPreviousButton(), constraint);
        constraint.gridx = 1;
        constraint.insets = editorInsets;
        c.add(this.createEditor(), constraint);
        constraint.gridx = 2;
        constraint.insets = buttonInsets;
        c.add(this.createNextButton(), constraint);
    }
}
