package Parameter.View;

import Scene.Model.ActionEnum;
import Structure.AbstractView;
import Utils.UI.CustomButton;
import Utils.UI.CustomLabel;
import Utils.UI.Utils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParametersMenuView extends AbstractView {

    private final CustomButton backButton;
    private final CustomButton themeAndSoundButton;
    private final CustomButton defaultPlayerButton;
    private final CustomButton resetButton;

    private final CustomLabel globalSettingsLabel;

    public ParametersMenuView() {
        super();
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridwidth = GridBagConstraints.REMAINDER;

        this.globalSettingsLabel = new CustomLabel("Global Parameters");
        this.globalSettingsLabel.setHorizontalAlignment(JLabel.CENTER);
        this.globalSettingsLabel.setFont(this.globalSettingsLabel.getFont().deriveFont(Utils.DEFAULT_SIZE_TITLE_LABEL));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(
                Utils.DEFAULT_BUTTON_PADDING_TOP,
                Utils.DEFAULT_BUTTON_PADDING_LEFT,
                Utils.DEFAULT_BUTTON_PADDING_BOTTOM + 85,
                Utils.DEFAULT_BUTTON_PADDING_RIGHT
        );
        this.add(this.globalSettingsLabel, constraints);

        constraints.insets = new Insets(
                Utils.DEFAULT_BUTTON_PADDING_TOP,
                Utils.DEFAULT_BUTTON_PADDING_LEFT,
                Utils.DEFAULT_BUTTON_PADDING_BOTTOM,
                Utils.DEFAULT_BUTTON_PADDING_RIGHT
        );

        this.themeAndSoundButton = new CustomButton("Theme personalisation and sound effect", Utils.DEFAULT_BUTTON_SIZE);
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(this.themeAndSoundButton, constraints);

        this.defaultPlayerButton = new CustomButton("Player personalisation", Utils.DEFAULT_BUTTON_SIZE);
        constraints.gridx = 0;
        constraints.gridy = 2;
        this.add(this.defaultPlayerButton, constraints);

        this.resetButton = new CustomButton("Reset Parameters", Utils.DEFAULT_BUTTON_SIZE);
        constraints.gridx = 0;
        constraints.gridy = 3;
        this.add(this.resetButton, constraints);

        this.backButton = new CustomButton("Back", Utils.DEFAULT_BUTTON_SIZE);
        constraints.gridx = 0;
        constraints.gridy = 4;
        this.add(this.backButton, constraints);

        this.initButtonsActionListeners();
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
