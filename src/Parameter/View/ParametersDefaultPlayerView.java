package Parameter.View;

import Scene.Model.ActionEnum;
import Structure.AbstractView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParametersDefaultPlayerView extends AbstractView {

    private final JButton backButton;

    public ParametersDefaultPlayerView() {
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
                ParametersDefaultPlayerView.this.observable.notifyObservers(ActionEnum.PARAMETERS_MENU);
            }
        });
    }
}
