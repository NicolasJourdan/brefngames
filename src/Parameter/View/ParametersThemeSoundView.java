package Parameter.View;

import Parameter.Factory.ColorFactory;
import Scene.Model.ActionEnum;
import Structure.AbstractView;
import Utils.UI.CustomButton;
import Utils.UI.CustomLabel;
import Utils.UI.CustomRadioButton;
import Utils.UI.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParametersThemeSoundView extends AbstractView {

    private CustomButton backButton;

    // Sound
    private CustomRadioButton soundOff;
    private CustomRadioButton soundOn;

    // First color
    private CustomRadioButton firstColorRed;
    private CustomRadioButton firstColorBlue;
    private CustomRadioButton firstColorGreen;
    private CustomRadioButton firstColorYellow;

    // Second color
    private CustomRadioButton secondColorWhite;
    private CustomRadioButton secondColorLightGray;
    private CustomRadioButton secondColorDarkGray;
    private CustomRadioButton secondColorBlack;

    private CustomLabel firstColorLabel;
    private CustomLabel secondColorLabel;
    private CustomLabel parametersSound;
    private CustomLabel parametersThemeSound;

    public ParametersThemeSoundView() {
        super();
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(
                Utils.DEFAULT_BUTTON_PADDING_TOP,
                Utils.DEFAULT_BUTTON_PADDING_LEFT,
                Utils.DEFAULT_BUTTON_PADDING_BOTTOM,
                Utils.DEFAULT_BUTTON_PADDING_RIGHT
        );

        constraints.anchor = GridBagConstraints.CENTER;

        this.parametersThemeSound = new CustomLabel("Theme and Sound Parameters");
        this.parametersThemeSound.setHorizontalAlignment(JLabel.CENTER);
        this.parametersThemeSound.setFont(this.parametersThemeSound.getFont().deriveFont(Utils.DEFAULT_SIZE_TITLE_LABEL));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        this.add(this.parametersThemeSound, constraints);

        constraints.anchor = GridBagConstraints.CENTER;

        this.firstColorLabel = new CustomLabel("Main Color");
        this.firstColorLabel.setFont(this.firstColorLabel.getFont().deriveFont(Utils.DEFAULT_SIZE_LABEL_PLAYER));
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        this.add(this.firstColorLabel, constraints);

        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridwidth = 1;

        constraints.gridy = 2;

        constraints.gridx = 0;
        this.firstColorRed = new CustomRadioButton(Utils.COLOR_RED);
        this.firstColorRed.setForeground(ColorFactory.getColor(Utils.COLOR_RED));
        this.add(this.firstColorRed, constraints);

        constraints.gridx = 1;
        this.firstColorBlue = new CustomRadioButton(Utils.COLOR_BLUE);
        this.firstColorBlue.setForeground(ColorFactory.getColor(Utils.COLOR_BLUE));
        this.add(this.firstColorBlue, constraints);

        constraints.gridx = 2;
        this.firstColorGreen = new CustomRadioButton(Utils.COLOR_GREEN);
        this.firstColorGreen.setForeground(ColorFactory.getColor(Utils.COLOR_GREEN));
        this.add(this.firstColorGreen, constraints);

        constraints.gridx = 3;
        this.firstColorYellow = new CustomRadioButton(Utils.COLOR_YELLOW);
        this.firstColorYellow.setForeground(ColorFactory.getColor(Utils.COLOR_YELLOW));
        this.add(this.firstColorYellow, constraints);

        ButtonGroup firstColorGroup = new ButtonGroup();
        firstColorGroup.add(this.firstColorRed);
        firstColorGroup.add(this.firstColorBlue);
        firstColorGroup.add(this.firstColorGreen);
        firstColorGroup.add(this.firstColorYellow);

        constraints.anchor = GridBagConstraints.CENTER;

        this.secondColorLabel = new CustomLabel("Second Color");
        this.secondColorLabel.setFont(this.secondColorLabel.getFont().deriveFont(Utils.DEFAULT_SIZE_LABEL_PLAYER));
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        this.add(this.secondColorLabel, constraints);

        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridwidth = 1;

        constraints.gridy = 4;

        this.secondColorWhite = new CustomRadioButton(Utils.COLOR_WHITE);
        this.secondColorWhite.setForeground(ColorFactory.getColor(Utils.COLOR_WHITE));
        this.secondColorLightGray = new CustomRadioButton(Utils.COLOR_LIGHT_GRAY);
        this.secondColorLightGray.setForeground(ColorFactory.getColor(Utils.COLOR_LIGHT_GRAY));
        this.secondColorDarkGray = new CustomRadioButton(Utils.COLOR_DARK_GRAY);
        this.secondColorDarkGray.setForeground(ColorFactory.getColor(Utils.COLOR_DARK_GRAY));
        this.secondColorBlack = new CustomRadioButton(Utils.COLOR_BLACK);
        this.secondColorBlack.setForeground(ColorFactory.getColor(Utils.COLOR_BLACK));


        constraints.gridx = 0;
        this.add(this.secondColorWhite, constraints);

        constraints.gridx = 1;
        this.add(this.secondColorLightGray, constraints);

        constraints.gridx = 2;
        this.add(this.secondColorDarkGray, constraints);

        constraints.gridx = 3;
        this.add(this.secondColorBlack, constraints);

        ButtonGroup secondColorGroup = new ButtonGroup();
        secondColorGroup.add(this.secondColorWhite);
        secondColorGroup.add(this.secondColorLightGray);
        secondColorGroup.add(this.secondColorDarkGray);
        secondColorGroup.add(this.secondColorBlack);

        constraints.anchor = GridBagConstraints.CENTER;

        this.parametersSound = new CustomLabel("Sound");
        this.parametersSound.setFont(this.parametersSound.getFont().deriveFont(Utils.DEFAULT_SIZE_LABEL_PLAYER));
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        this.add(this.parametersSound, constraints);

        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridwidth = 2;

        constraints.gridy = 6;


        this.soundOff = new CustomRadioButton("Off");
        this.soundOn = new CustomRadioButton("On");

        ButtonGroup soundGroup = new ButtonGroup();
        soundGroup.add(this.soundOff);
        soundGroup.add(this.soundOn);

        constraints.gridx = 0;
        constraints.gridwidth = 2;
        this.add(this.soundOff, constraints);
        constraints.gridx = 2;
        constraints.gridwidth = 2;
        this.add(this.soundOn, constraints);

        constraints.anchor = GridBagConstraints.CENTER;

        this.backButton = new CustomButton("Back");
        constraints.gridy = 7;
        constraints.gridx = 1;
        constraints.gridwidth = 2;
        this.add(this.backButton, constraints);

        this.initButtonsActionListeners();
    }

    private void initButtonsActionListeners() {
        this.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersThemeSoundView.this.observable.notifyObservers(ActionEnum.PARAMETERS_MENU);
            }
        });

        // Sound
        this.soundOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersThemeSoundView.this.observable.notifyObservers(ActionEnum.SOUND_OFF);
            }
        });

        this.soundOn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersThemeSoundView.this.observable.notifyObservers(ActionEnum.SOUND_ON);
            }
        });

        // First color
        this.firstColorRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersThemeSoundView.this.observable.notifyObservers(ActionEnum.FIRST_COLOR_RED);
            }
        });

        this.firstColorBlue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersThemeSoundView.this.observable.notifyObservers(ActionEnum.FIRST_COLOR_BLUE);
            }
        });

        this.firstColorGreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersThemeSoundView.this.observable.notifyObservers(ActionEnum.FIRST_COLOR_GREEN);
            }
        });

        this.firstColorYellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersThemeSoundView.this.observable.notifyObservers(ActionEnum.FIRST_COLOR_YELLOW);
            }
        });

        // Second color
        this.secondColorWhite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersThemeSoundView.this.observable.notifyObservers(ActionEnum.SECOND_COLOR_WHITE);
            }
        });

        this.secondColorLightGray.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersThemeSoundView.this.observable.notifyObservers(ActionEnum.SECOND_COLOR_LIGHT_GRAY);
            }
        });

        this.secondColorDarkGray.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersThemeSoundView.this.observable.notifyObservers(ActionEnum.SECOND_COLOR_DARK_GRAY);
            }
        });

        this.secondColorBlack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersThemeSoundView.this.observable.notifyObservers(ActionEnum.SECOND_COLOR_BLACK);
            }
        });

    }

    // Call by the Controller
    public void initSoundButtons(ActionEnum actionEnum) {
        switch (actionEnum) {
            case SOUND_ON:
                this.soundOn.setSelected(true);
                break;
            case SOUND_OFF:
                this.soundOff.setSelected(true);
                break;
            default:
                throw new RuntimeException("The action : " + actionEnum + "is not acceptable here");
        }
    }

    // Call by the Controller
    public void initFirstColorButtons(ActionEnum actionEnum) {
        switch (actionEnum) {
            case FIRST_COLOR_RED:
                this.firstColorRed.setSelected(true);
                break;
            case FIRST_COLOR_BLUE:
                this.firstColorBlue.setSelected(true);
                break;
            case FIRST_COLOR_GREEN:
                this.firstColorGreen.setSelected(true);
                break;
            case FIRST_COLOR_YELLOW:
                this.firstColorYellow.setSelected(true);
                break;
            default:
                throw new RuntimeException("The action : " + actionEnum + " is not acceptable here");
        }
    }

    // Call by the controller
    public void initSecondColorButtons(ActionEnum actionEnum) {
        switch (actionEnum) {
            case SECOND_COLOR_WHITE:
                this.secondColorWhite.setSelected(true);
                break;
            case SECOND_COLOR_LIGHT_GRAY:
                this.secondColorLightGray.setSelected(true);
                break;
            case SECOND_COLOR_DARK_GRAY:
                this.secondColorDarkGray.setSelected(true);
                break;
            case SECOND_COLOR_BLACK:
                this.secondColorBlack.setSelected(true);
                break;
            default:
                throw new RuntimeException("The action : " + actionEnum + "is not acceptable here");
        }
    }
}
