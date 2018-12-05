package Parameter.View;

import Scene.Model.ActionEnum;
import Structure.AbstractView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParametersMenuView extends AbstractView {

    private final JButton backButton;
    private final JButton themeAndSoundButton;
    private final JButton defaultPlayerButton;
    private final JButton resetButton;

    public ParametersMenuView() {
        super();
        this.setLayout(new GridLayout());

        this.backButton = new JButton("Back");
        this.themeAndSoundButton = new JButton("Theme personalisation and sound effect");
        this.defaultPlayerButton = new JButton("Player personalisation");
        this.resetButton = new JButton("Reset Parameters");

        this.initButtonsActionListeners();

        this.add(this.backButton);
        this.add(this.themeAndSoundButton);
        this.add(this.defaultPlayerButton);
        this.add(this.resetButton);
    }

    private void initButtonsActionListeners() {
        this.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersMenuView.this.observable.notifyObservers(ActionEnum.END_PARAMETERS);
            }
        });

        this.themeAndSoundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersMenuView.this.observable.notifyObservers(ActionEnum.THEME_SOUND_PARAMETERS);
            }
        });

        this.defaultPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersMenuView.this.observable.notifyObservers(ActionEnum.PLAYER_PARAMETERS);
            }
        });

        this.resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersMenuView.this.observable.notifyObservers(ActionEnum.RESET_PARAMETERS);
            }
        });
    }
}
