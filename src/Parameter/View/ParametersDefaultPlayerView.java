package Parameter.View;

import Parameter.Factory.ColorFactory;
import Scene.Model.ActionEnum;
import Structure.AbstractView;
import Utils.UI.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParametersDefaultPlayerView extends AbstractView {

    private CustomButton backButton;

    // First icon player
    private CustomRadioButton firstIconSuperman;
    private CustomRadioButton firstIconBatman;
    private CustomRadioButton firstIconFlash;
    private CustomRadioButton firstIconAquaman;

    // Second icon player
    private CustomRadioButton secondIconSuperman;
    private CustomRadioButton secondIconBatman;
    private CustomRadioButton secondIconFlash;
    private CustomRadioButton secondIconAquaman;

    // First color player
    private CustomRadioButton firstColorPlayerRed;
    private CustomRadioButton firstColorPlayerBlue;
    private CustomRadioButton firstColorPlayerGreen;
    private CustomRadioButton firstColorPlayerYellow;

    // Second color player
    private CustomRadioButton secondColorPlayerRed;
    private CustomRadioButton secondColorPlayerBlue;
    private CustomRadioButton secondColorPlayerGreen;
    private CustomRadioButton secondColorPlayerYellow;

    private CustomLabel warningLabel;
    private CustomLabel firstPlayerLabel;
    private CustomLabel secondPlayerLabel;
    private CustomLabel parametersPlayersLabel;
    
    public ParametersDefaultPlayerView() {
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

        this.parametersPlayersLabel = new CustomLabel("Player Parameters");
        this.parametersPlayersLabel.setHorizontalAlignment(JLabel.CENTER);
        this.parametersPlayersLabel.setFont(this.parametersPlayersLabel.getFont().deriveFont(Utils.DEFAULT_SIZE_TITLE_LABEL));
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        this.add(this.parametersPlayersLabel, constraints);

        constraints.anchor = GridBagConstraints.WEST;

        // Second
        this.secondIconSuperman = new CustomRadioButton(Utils.SUPERMAN);
        this.secondIconBatman = new CustomRadioButton(Utils.BATMAN);
        this.secondIconFlash = new CustomRadioButton(Utils.FLASH);
        this.secondIconAquaman = new CustomRadioButton(Utils.AQUAMAN);
        // Second
        this.secondColorPlayerRed = new CustomRadioButton(Utils.COLOR_RED);
        this.secondColorPlayerRed.setForeground(ColorFactory.getColor(Utils.COLOR_RED));
        this.secondColorPlayerBlue = new CustomRadioButton(Utils.COLOR_BLUE);
        this.secondColorPlayerBlue.setForeground(ColorFactory.getColor(Utils.COLOR_BLUE));
        this.secondColorPlayerGreen = new CustomRadioButton(Utils.COLOR_GREEN);
        this.secondColorPlayerGreen.setForeground(ColorFactory.getColor(Utils.COLOR_GREEN));
        this.secondColorPlayerYellow = new CustomRadioButton(Utils.COLOR_YELLOW);
        this.secondColorPlayerYellow.setForeground(ColorFactory.getColor(Utils.COLOR_YELLOW));

        constraints.anchor = GridBagConstraints.CENTER;

        this.firstPlayerLabel = new CustomLabel("Player 1");
        this.firstPlayerLabel.setFont(this.firstPlayerLabel.getFont().deriveFont(Utils.DEFAULT_SIZE_LABEL_PLAYER));
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        this.add(this.firstPlayerLabel, constraints);

        constraints.anchor = GridBagConstraints.WEST;

        constraints.gridwidth = 1;

        // First
        this.firstIconSuperman = new CustomRadioButton(Utils.SUPERMAN);
        this.firstIconBatman = new CustomRadioButton(Utils.BATMAN);
        this.firstIconFlash = new CustomRadioButton(Utils.FLASH);
        this.firstIconAquaman = new CustomRadioButton(Utils.AQUAMAN);
        // First
        this.firstColorPlayerRed = new CustomRadioButton(Utils.COLOR_RED);
        this.firstColorPlayerRed.setForeground(ColorFactory.getColor(Utils.COLOR_RED));
        this.firstColorPlayerBlue = new CustomRadioButton(Utils.COLOR_BLUE);
        this.firstColorPlayerBlue.setForeground(ColorFactory.getColor(Utils.COLOR_BLUE));
        this.firstColorPlayerGreen = new CustomRadioButton(Utils.COLOR_GREEN);
        this.firstColorPlayerGreen.setForeground(ColorFactory.getColor(Utils.COLOR_GREEN));
        this.firstColorPlayerYellow = new CustomRadioButton(Utils.COLOR_YELLOW);
        this.firstColorPlayerYellow.setForeground(ColorFactory.getColor(Utils.COLOR_YELLOW));


        constraints.gridy = 2;

        constraints.gridx = 0;
        this.add(this.firstIconSuperman, constraints);
        constraints.gridx = 1;
        this.add(this.firstIconBatman, constraints);
        constraints.gridx = 2;
        this.add(this.firstIconFlash, constraints);
        constraints.gridx = 3;
        this.add(this.firstIconAquaman, constraints);

        ButtonGroup firstIconGroup = new ButtonGroup();
        firstIconGroup.add(this.firstIconSuperman);
        firstIconGroup.add(this.firstIconBatman);
        firstIconGroup.add(this.firstIconFlash);
        firstIconGroup.add(this.firstIconAquaman);

        constraints.gridy = 3;

        constraints.gridx = 0;
        this.add(this.firstColorPlayerRed, constraints);
        constraints.gridx = 1;
        this.add(this.firstColorPlayerBlue, constraints);
        constraints.gridx = 2;
        this.add(this.firstColorPlayerGreen, constraints);
        constraints.gridx = 3;
        this.add(this.firstColorPlayerYellow, constraints);

        ButtonGroup firstColorGroup = new ButtonGroup();
        firstColorGroup.add(this.firstColorPlayerRed);
        firstColorGroup.add(this.firstColorPlayerBlue);
        firstColorGroup.add(this.firstColorPlayerGreen);
        firstColorGroup.add(this.firstColorPlayerYellow);

        constraints.anchor = GridBagConstraints.CENTER;

        this.secondPlayerLabel = new CustomLabel("Player 2");
        this.secondPlayerLabel.setFont(this.secondPlayerLabel.getFont().deriveFont(Utils.DEFAULT_SIZE_LABEL_PLAYER));
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        this.add(this.secondPlayerLabel, constraints);

        constraints.anchor = GridBagConstraints.WEST;

        constraints.gridwidth = 1;
        constraints.gridy = 5;

        constraints.gridx = 0;
        this.add(this.secondIconSuperman, constraints);
        constraints.gridx = 1;
        this.add(this.secondIconBatman, constraints);
        constraints.gridx = 2;
        this.add(this.secondIconFlash, constraints);
        constraints.gridx = 3;
        this.add(this.secondIconAquaman, constraints);

        ButtonGroup secondIconGroup = new ButtonGroup();
        secondIconGroup.add(this.secondIconSuperman);
        secondIconGroup.add(this.secondIconBatman);
        secondIconGroup.add(this.secondIconFlash);
        secondIconGroup.add(this.secondIconAquaman);

        constraints.gridy = 6;

        constraints.gridx = 0;
        this.add(this.secondColorPlayerRed, constraints);
        constraints.gridx = 1;
        this.add(this.secondColorPlayerBlue, constraints);
        constraints.gridx = 2;
        this.add(this.secondColorPlayerGreen, constraints);
        constraints.gridx = 3;
        this.add(this.secondColorPlayerYellow, constraints);

        ButtonGroup secondColorGroup = new ButtonGroup();
        secondColorGroup.add(this.secondColorPlayerRed);
        secondColorGroup.add(this.secondColorPlayerBlue);
        secondColorGroup.add(this.secondColorPlayerGreen);
        secondColorGroup.add(this.secondColorPlayerYellow);

        constraints.anchor = GridBagConstraints.CENTER;

        this.backButton = new CustomButton("Back");
        constraints.gridx = 1;
        constraints.gridy = 7;
        constraints.gridwidth = 2;
        this.add(this.backButton, constraints);

        this.warningLabel = new WarningLabel("");
        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.gridwidth = 4;
        this.add(this.warningLabel, constraints);

        this.initButtonsActionListeners();
    }

    private void initButtonsActionListeners() {
        this.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersDefaultPlayerView.this.observable.notifyObservers(ActionEnum.PARAMETERS_MENU);
            }
        });

        this.firstIconSuperman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersDefaultPlayerView.this.observable.notifyObservers(ActionEnum.SUPERMAN_1);
            }
        });

        this.firstIconBatman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersDefaultPlayerView.this.observable.notifyObservers(ActionEnum.BATMAN_1);
            }
        });

        this.firstIconFlash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersDefaultPlayerView.this.observable.notifyObservers(ActionEnum.FLASH_1);
            }
        });

        this.firstIconAquaman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersDefaultPlayerView.this.observable.notifyObservers(ActionEnum.AQUAMAN_1);
            }
        });

        this.secondIconSuperman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersDefaultPlayerView.this.observable.notifyObservers(ActionEnum.SUPERMAN_2);
            }
        });

        this.secondIconBatman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersDefaultPlayerView.this.observable.notifyObservers(ActionEnum.BATMAN_2);
            }
        });

        this.secondIconFlash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersDefaultPlayerView.this.observable.notifyObservers(ActionEnum.FLASH_2);
            }
        });

        this.secondIconAquaman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersDefaultPlayerView.this.observable.notifyObservers(ActionEnum.AQUAMAN_2);
            }
        });

        this.firstColorPlayerRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersDefaultPlayerView.this.observable.notifyObservers(ActionEnum.COLOR_FIRST_PLAYER_RED);
            }
        });

        this.firstColorPlayerBlue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersDefaultPlayerView.this.observable.notifyObservers(ActionEnum.COLOR_FIRST_PLAYER_BLUE);
            }
        });

        this.firstColorPlayerGreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersDefaultPlayerView.this.observable.notifyObservers(ActionEnum.COLOR_FIRST_PLAYER_GREEN);
            }
        });

        this.firstColorPlayerYellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersDefaultPlayerView.this.observable.notifyObservers(ActionEnum.COLOR_FIRST_PLAYER_YELLOW);
            }
        });

        this.secondColorPlayerRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersDefaultPlayerView.this.observable.notifyObservers(ActionEnum.COLOR_SECOND_PLAYER_RED);
            }
        });

        this.secondColorPlayerBlue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersDefaultPlayerView.this.observable.notifyObservers(ActionEnum.COLOR_SECOND_PLAYER_BLUE);
            }
        });

        this.secondColorPlayerGreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersDefaultPlayerView.this.observable.notifyObservers(ActionEnum.COLOR_SECOND_PLAYER_GREEN);
            }
        });

        this.secondColorPlayerYellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParametersDefaultPlayerView.this.observable.notifyObservers(ActionEnum.COLOR_SECOND_PLAYER_YELLOW);
            }
        });
    }

    // Call by the controller
    public void initIconFirstPlayer(ActionEnum actionEnum) {
        switch (actionEnum) {
            case SUPERMAN_1:
                this.firstIconSuperman.setSelected(true);
                break;
            case BATMAN_1:
                this.firstIconBatman.setSelected(true);
                break;
            case FLASH_1:
                this.firstIconFlash.setSelected(true);
                break;
            case AQUAMAN_1:
                this.firstIconAquaman.setSelected(true);
                break;
            default:
                throw new RuntimeException("The action : " + actionEnum + " is not acceptable here");
        }
    }

    // Call by the controller
    public void initIconSecondPlayer(ActionEnum actionEnum) {
        switch (actionEnum) {
            case SUPERMAN_2:
                this.secondIconSuperman.setSelected(true);
                break;
            case BATMAN_2:
                this.secondIconBatman.setSelected(true);
                break;
            case FLASH_2:
                this.secondIconFlash.setSelected(true);
                break;
            case AQUAMAN_2:
                this.secondIconAquaman.setSelected(true);
                break;
            default:
                throw new RuntimeException("The action : " + actionEnum + " is not acceptable here");
        }
    }

    // Call by the controller
    public void initColorFirstPlayer(ActionEnum actionEnum) {
        switch (actionEnum) {
            case COLOR_FIRST_PLAYER_RED:
                this.firstColorPlayerRed.setSelected(true);
                break;
            case COLOR_FIRST_PLAYER_BLUE:
                this.firstColorPlayerBlue.setSelected(true);
                break;
            case COLOR_FIRST_PLAYER_GREEN:
                this.firstColorPlayerGreen.setSelected(true);
                break;
            case COLOR_FIRST_PLAYER_YELLOW:
                this.firstColorPlayerYellow.setSelected(true);
                break;
            default:
                throw new RuntimeException("The action : " + actionEnum + " is not acceptable here");
        }
    }

    // Call by the controller
    public void initColorSecondPlayer(ActionEnum actionEnum) {
        switch (actionEnum) {
            case COLOR_SECOND_PLAYER_RED:
                this.secondColorPlayerRed.setSelected(true);
                break;
            case COLOR_SECOND_PLAYER_BLUE:
                this.secondColorPlayerBlue.setSelected(true);
                break;
            case COLOR_SECOND_PLAYER_GREEN:
                this.secondColorPlayerGreen.setSelected(true);
                break;
            case COLOR_SECOND_PLAYER_YELLOW:
                this.secondColorPlayerYellow.setSelected(true);
                break;
            default:
                throw new RuntimeException("The action : " + actionEnum + " is not acceptable here");
        }
    }

    /**
     * Set a warning label
     *
     * @param invalidDataObjectText
     */
    public void updateWarningMessage(String invalidDataObjectText) {
        this.warningLabel.setText(invalidDataObjectText);
        this.revalidate();
        this.repaint();
    }
}
