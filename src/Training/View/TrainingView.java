package Training.View;

import Scene.Model.ActionEnum;
import Structure.AbstractView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrainingView extends AbstractView {

    private final JButton menuButton;

    public TrainingView() {
        super();
        this.setLayout(new GridLayout());

        this.menuButton = new JButton("Menu");
        this.initButtonsActionListeners();
        this.add(this.menuButton);
    }

    private void initButtonsActionListeners() {
        this.menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrainingView.this.observable.notifyObservers(ActionEnum.END_TRAINING);
            }
        });
    }
}
