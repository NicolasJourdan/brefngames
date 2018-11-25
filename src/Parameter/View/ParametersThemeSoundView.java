package Parameter.View;

import Scene.Model.ActionEnum;
import Structure.AbstractView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParametersThemeSoundView extends AbstractView {

    private JButton backButton;

    // Sound
    private JRadioButton soundOff;
    private JRadioButton soundOn;

    // First color
    private JRadioButton firstColorRed;
    private JRadioButton firstColorBlue;
    private JRadioButton firstColorGreen;
    private JRadioButton firstColorYellow;

    // Second color
    private JRadioButton secondColorWhite;
    private JRadioButton secondColorLightGray;
    private JRadioButton secondColorDarkGray;
    private JRadioButton secondColorBlack;

    public ParametersThemeSoundView() {
        super();
        this.setLayout(new GridLayout(3, 4));

        this.backButton = new JButton("Back");

        this.soundOff = new JRadioButton("Off");
        this.soundOn = new JRadioButton("On");

        this.firstColorRed = new JRadioButton("Red");
        this.firstColorBlue = new JRadioButton("Blue");
        this.firstColorGreen = new JRadioButton("Green");
        this.firstColorYellow = new JRadioButton("Yellow");

        this.secondColorWhite = new JRadioButton("White");
        this.secondColorLightGray = new JRadioButton("Light Gray");
        this.secondColorDarkGray = new JRadioButton("Dark Gray");
        this.secondColorBlack = new JRadioButton("Black");

        ButtonGroup soundGroup = new ButtonGroup();
        soundGroup.add(this.soundOff);
        soundGroup.add(this.soundOn);

        ButtonGroup firstColorGroup = new ButtonGroup();
        firstColorGroup.add(this.firstColorRed);
        firstColorGroup.add(this.firstColorBlue);
        firstColorGroup.add(this.firstColorGreen);
        firstColorGroup.add(this.firstColorYellow);

        ButtonGroup secondColorGroup = new ButtonGroup();
        secondColorGroup.add(this.secondColorWhite);
        secondColorGroup.add(this.secondColorLightGray);
        secondColorGroup.add(this.secondColorDarkGray);
        secondColorGroup.add(this.secondColorBlack);

        this.initButtonsActionListeners();

        this.add(this.firstColorRed);
        this.add(this.firstColorBlue);
        this.add(this.firstColorGreen);
        this.add(this.firstColorYellow);

        this.add(this.secondColorWhite);
        this.add(this.secondColorLightGray);
        this.add(this.secondColorDarkGray);
        this.add(this.secondColorBlack);

        this.add(this.soundOff);
        this.add(this.soundOn);

        this.add(this.backButton);
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
