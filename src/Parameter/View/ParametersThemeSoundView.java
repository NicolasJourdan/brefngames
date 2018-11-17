package Parameter.View;

import Scene.Model.ActionEnum;
import Structure.AbstractView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParametersThemeSoundView extends AbstractView {

    private final JButton backButton;

    public ParametersThemeSoundView() {
        super();
        this.setLayout(new GridLayout());

        this.backButton = new JButton("Back");

        this.initButtonsActionListeners();

        this.add(this.backButton);
    }

    private void initButtonsActionListeners() {
        this.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersThemeSoundView.this.observable.notifyObservers(ActionEnum.PARAMETERS_MENU);
            }
        });
    }
}
