package ContestSettings.View;

import ContestSettings.DataObject.ContestSettingsDataObject;
import Game.Model.GameEnum;
import Parameter.Factory.ColorFactory;
import Parameter.Factory.IconFactory;
import Parameter.Parameters.ColorParameter;
import Scene.Model.ActionEnum;

import Parameter.Model.ParameterEnum;
import Parameter.Parameters.Configurable;
import Parameter.Parameters.IconParameter;
import Structure.AbstractView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContestSettingsView extends AbstractView {

    public final static int NB_MAX_GAMES = 7;
    public final static int NB_MIN_GAMES = 1;
    public final static int NB_DEFAULT_GAMES = 4;
    public final static int NB_STEP_GAMES = 1;
    public final static int COLUMNS_PLAYER_NAME_TEXTFIELD = 15;

    public final static String DEFAULT_FIRST_PLAYER_NAME = "Player 1";
    public final static String DEFAULT_SECOND_PLAYER_NAME = "Player 2";

    private final JCheckBox ticTacToeCheckbox;
    private final JCheckBox connectFourCheckbox;
    private final JCheckBox cookieClickerCheckbox;
    private final JCheckBox runnerCheckbox;
    private final JSpinner spinnerNbGames;

    private final JTextField firstPlayerName;
    private final JTextField secondPlayerName;

    // First icon player
    private JRadioButton firstIconSuperman;
    private JRadioButton firstIconBatman;
    private JRadioButton firstIconFlash;
    private JRadioButton firstIconAquaman;

    // Second icon player
    private JRadioButton secondIconSuperman;
    private JRadioButton secondIconBatman;
    private JRadioButton secondIconFlash;
    private JRadioButton secondIconAquaman;

    // First color player
    private JRadioButton firstColorPlayerRed;
    private JRadioButton firstColorPlayerBlue;
    private JRadioButton firstColorPlayerGreen;
    private JRadioButton firstColorPlayerYellow;

    // Second color player
    private JRadioButton secondColorPlayerRed;
    private JRadioButton secondColorPlayerBlue;
    private JRadioButton secondColorPlayerGreen;
    private JRadioButton secondColorPlayerYellow;

    private final JButton startButton;
    private final JButton backButton;

    private final JLabel warningLabel;

    public ContestSettingsView() {
        this.setLayout(
            new GridBagLayout()
        );

        // reusable GridBagConstraint to place every needed components
        GridBagConstraints constraint = new GridBagConstraints();

        constraint.gridy = 0;
        constraint.gridx = 0;
        constraint.gridwidth = 2;
        constraint.gridheight = 1;

        this.add(new JLabel("Contest customization"), constraint);

        // Game checkboxes
        constraint.gridy = 1;
        constraint.gridwidth = 1;
        this.ticTacToeCheckbox = new JCheckBox("Tic Tac Toe");
        this.ticTacToeCheckbox.setSelected(true);
        this.add(this.ticTacToeCheckbox, constraint);

        constraint.gridy = 2;
        this.connectFourCheckbox = new JCheckBox("Connect Four");
        this.connectFourCheckbox.setSelected(true);
        this.add(this.connectFourCheckbox, constraint);

        constraint.gridy = 3;
        this.cookieClickerCheckbox = new JCheckBox("CookieView Clicker");
        this.cookieClickerCheckbox.setSelected(true);
        this.add(this.cookieClickerCheckbox, constraint);

        constraint.gridy = 4;
        this.runnerCheckbox = new JCheckBox("Runner");
        this.runnerCheckbox.setSelected(true);
        this.add(this.runnerCheckbox, constraint);

        // number of matches
        constraint.gridy = 5;
        JPanel nbGamesPanel = new JPanel();
        nbGamesPanel.setLayout(new FlowLayout());

        JLabel nbGamesLabel = new JLabel("Number of matches");
        nbGamesPanel.add(nbGamesLabel);
        this.spinnerNbGames = new JSpinner(
            new SpinnerNumberModel(
                NB_DEFAULT_GAMES,
                NB_MIN_GAMES,
                NB_MAX_GAMES,
                NB_STEP_GAMES
            )
        );
        nbGamesPanel.add(this.spinnerNbGames);

        this.add(nbGamesPanel, constraint);

        // players
        constraint.gridx = 1;
        constraint.gridy = 1;
        constraint.gridheight = 2;

        GridBagConstraints constraintPlayerPanel = new GridBagConstraints();

        // Player 1
        JPanel firstPlayerPanel = new JPanel();
        firstPlayerPanel.setLayout(new GridBagLayout());
        firstPlayerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        firstPlayerPanel.add(new JLabel("Player 1"), constraintPlayerPanel);

        constraintPlayerPanel.gridx = 1;
        this.firstPlayerName = new JTextField(ContestSettingsView.DEFAULT_FIRST_PLAYER_NAME, COLUMNS_PLAYER_NAME_TEXTFIELD);
        firstPlayerPanel.add(this.firstPlayerName, constraintPlayerPanel);

        this.firstIconSuperman = new JRadioButton("Superman_1");
        this.firstIconBatman = new JRadioButton("Batman_1");
        this.firstIconFlash = new JRadioButton("Flash_1");
        this.firstIconAquaman = new JRadioButton("Aquaman_1");

        this.firstColorPlayerRed = new JRadioButton("Red_1");
        this.firstColorPlayerBlue = new JRadioButton("Blue_1");
        this.firstColorPlayerGreen = new JRadioButton("Green_1");
        this.firstColorPlayerYellow = new JRadioButton("Yellow_1");

        ButtonGroup firstIconGroup = new ButtonGroup();
        firstIconGroup.add(this.firstIconSuperman);
        firstIconGroup.add(this.firstIconBatman);
        firstIconGroup.add(this.firstIconFlash);
        firstIconGroup.add(this.firstIconAquaman);

        JPanel firstIconGroupPanel =  new JPanel();
        firstIconGroupPanel.add(this.firstIconSuperman);
        firstIconGroupPanel.add(this.firstIconBatman);
        firstIconGroupPanel.add(this.firstIconFlash);
        firstIconGroupPanel.add(this.firstIconAquaman);

        constraintPlayerPanel.gridy = 2;
        firstPlayerPanel.add(firstIconGroupPanel, constraintPlayerPanel);

        ButtonGroup firstColorGroup = new ButtonGroup();
        firstColorGroup.add(this.firstColorPlayerRed);
        firstColorGroup.add(this.firstColorPlayerBlue);
        firstColorGroup.add(this.firstColorPlayerGreen);
        firstColorGroup.add(this.firstColorPlayerYellow);

        JPanel firstColorGroupPanel = new JPanel();
        firstColorGroupPanel.add(this.firstColorPlayerRed);
        firstColorGroupPanel.add(this.firstColorPlayerBlue);
        firstColorGroupPanel.add(this.firstColorPlayerGreen);
        firstColorGroupPanel.add(this.firstColorPlayerYellow);

        constraintPlayerPanel.gridy = 3;
        firstPlayerPanel.add(firstColorGroupPanel, constraintPlayerPanel);

        this.add(firstPlayerPanel, constraint);

        // Player 2
        JPanel secondPlayerPanel = new JPanel();
        secondPlayerPanel.setLayout(new GridBagLayout());
        secondPlayerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        constraintPlayerPanel.gridx = 0;
        constraintPlayerPanel.gridy = 0;
        secondPlayerPanel.add(new JLabel("Player 2"), constraintPlayerPanel);

        constraintPlayerPanel.gridx = 1;
        this.secondPlayerName = new JTextField(ContestSettingsView.DEFAULT_SECOND_PLAYER_NAME, COLUMNS_PLAYER_NAME_TEXTFIELD);
        secondPlayerPanel.add(this.secondPlayerName, constraintPlayerPanel);

        this.secondColorPlayerRed = new JRadioButton("Red_2");
        this.secondColorPlayerBlue = new JRadioButton("Blue_2");
        this.secondColorPlayerGreen = new JRadioButton("Green_2");
        this.secondColorPlayerYellow = new JRadioButton("Yellow_2");

        this.secondIconSuperman = new JRadioButton("Superman_2");
        this.secondIconBatman = new JRadioButton("Batman_2");
        this.secondIconFlash = new JRadioButton("Flash_2");
        this.secondIconAquaman = new JRadioButton("Aquaman_2");

        ButtonGroup secondIconGroup = new ButtonGroup();
        secondIconGroup.add(this.secondIconSuperman);
        secondIconGroup.add(this.secondIconBatman);
        secondIconGroup.add(this.secondIconFlash);
        secondIconGroup.add(this.secondIconAquaman);

        JPanel secondIconGroupPanel =  new JPanel();
        secondIconGroupPanel.add(this.secondIconSuperman);
        secondIconGroupPanel.add(this.secondIconBatman);
        secondIconGroupPanel.add(this.secondIconFlash);
        secondIconGroupPanel.add(this.secondIconAquaman);

        constraintPlayerPanel.gridy = 2;
        secondPlayerPanel.add(secondIconGroupPanel, constraintPlayerPanel);

        ButtonGroup secondColorGroup = new ButtonGroup();
        secondColorGroup.add(this.secondColorPlayerRed);
        secondColorGroup.add(this.secondColorPlayerBlue);
        secondColorGroup.add(this.secondColorPlayerGreen);
        secondColorGroup.add(this.secondColorPlayerYellow);

        JPanel secondColorGroupPanel = new JPanel();
        secondColorGroupPanel.add(this.secondColorPlayerRed);
        secondColorGroupPanel.add(this.secondColorPlayerBlue);
        secondColorGroupPanel.add(this.secondColorPlayerGreen);
        secondColorGroupPanel.add(this.secondColorPlayerYellow);

        constraintPlayerPanel.gridy = 3;
        secondPlayerPanel.add(secondColorGroupPanel, constraintPlayerPanel);

        constraint.gridy = 3;
        this.add(secondPlayerPanel, constraint);

        // Start button
        constraint.gridy = 5;
        constraint.gridheight = 1;
        this.startButton = new JButton("Start");
        this.add(this.startButton, constraint);

        this.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContestSettingsView.this.observable.notifyObservers(ActionEnum.START_CONTEST);
            }
        });

        // Back button
        constraint.gridy = 6;
        constraint.gridheight = 1;
        this.backButton = new JButton("Back");
        this.add(this.backButton, constraint);

        this.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContestSettingsView.this.observable.notifyObservers(ActionEnum.END_CONTEST);
            }
        });

        // Warning label
        constraint.gridx = 0;
        constraint.gridy = 7;
        constraint.gridwidth = 2;
        this.warningLabel = new JLabel("");
        this.warningLabel.setForeground(Color.RED);
        this.add(this.warningLabel, constraint);
    }

    public void setDefaultConfiguration(Map<ParameterEnum, Configurable> defaultConfiguration) {
        String iconNameFirstPlayer = ((IconParameter) defaultConfiguration.get(ParameterEnum.PLAYER_1_ICON)).getName();
        ActionEnum iconFirstPlayer = ActionEnum.valueOf(iconNameFirstPlayer);

        switch (iconFirstPlayer) {
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
                throw new RuntimeException("The action : " + iconFirstPlayer + " is not acceptable here");
        }

        String iconNameSecondPlayer = ((IconParameter) defaultConfiguration.get(ParameterEnum.PLAYER_2_ICON)).getName();
        ActionEnum iconSecondPlayer = ActionEnum.valueOf(iconNameSecondPlayer);

        switch (iconSecondPlayer) {
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
                throw new RuntimeException("The action : " + iconSecondPlayer + " is not acceptable here");
        }


        String colorNameFirstPlayer = ((ColorParameter) defaultConfiguration.get(ParameterEnum.PLAYER_1_COLOR)).getStringColor();
        ActionEnum colorFirstPlayer = ActionEnum.valueOf(colorNameFirstPlayer);

        switch (colorFirstPlayer) {
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
                throw new RuntimeException("The action : " + colorFirstPlayer + " is not acceptable here");
        }

        String colorNameSecondPlayer = ((ColorParameter) defaultConfiguration.get(ParameterEnum.PLAYER_2_COLOR)).getStringColor();
        ActionEnum colorSecondPlayer = ActionEnum.valueOf(colorNameSecondPlayer);

        switch (colorSecondPlayer) {
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
                throw new RuntimeException("The action : " + colorSecondPlayer + " is not acceptable here");
        }
    }

    public ContestSettingsDataObject getSettingsDataObject() {
        return new ContestSettingsDataObject(
                (Integer) this.spinnerNbGames.getValue(),
                this.gameSelectedGameTypes(),
                this.firstPlayerName.getText(),
                this.getFirstPlayerIcon(),
                this.getFirstPlayerColor(),
                this.secondPlayerName.getText(),
                this.getSecondPlayerIcon(),
                this.getSecondPlayerColor()
        );
    }

    private ImageIcon getFirstPlayerIcon() {
        if (this.firstIconAquaman.isSelected()) {
            return IconFactory.getIcon("AQUAMAN");
        }
        if (this.firstIconBatman.isSelected()) {
            return IconFactory.getIcon("BATMAN");
        }
        if (this.firstIconFlash.isSelected()) {
            return IconFactory.getIcon("FLASH");
        }
        if (this.firstIconSuperman.isSelected()) {
            return IconFactory.getIcon("SUPERMAN");
        }

        return null;
    }

    private ImageIcon getSecondPlayerIcon() {
        if (this.secondIconAquaman.isSelected()) {
            return IconFactory.getIcon("AQUAMAN");
        }
        if (this.secondIconBatman.isSelected()) {
            return IconFactory.getIcon("BATMAN");
        }
        if (this.secondIconFlash.isSelected()) {
            return IconFactory.getIcon("FLASH");
        }
        if (this.secondIconSuperman.isSelected()) {
            return IconFactory.getIcon("SUPERMAN");
        }

        return null;
    }

    private Color getFirstPlayerColor() {
        if (this.firstColorPlayerBlue.isSelected()) {
            return ColorFactory.getColor("BLUE");
        }
        if (this.firstColorPlayerGreen.isSelected()) {
            return ColorFactory.getColor("GREEN");
        }
        if (this.firstColorPlayerRed.isSelected()) {
            return ColorFactory.getColor("RED");
        }
        if (this.firstColorPlayerYellow.isSelected()) {
            return ColorFactory.getColor("YELLOW");
        }

        return null;
    }

    private Color getSecondPlayerColor() {
        if (this.secondColorPlayerBlue.isSelected()) {
            return ColorFactory.getColor("BLUE");
        }
        if (this.secondColorPlayerGreen.isSelected()) {
            return ColorFactory.getColor("GREEN");
        }
        if (this.secondColorPlayerRed.isSelected()) {
            return ColorFactory.getColor("RED");
        }
        if (this.secondColorPlayerYellow.isSelected()) {
            return ColorFactory.getColor("YELLOW");
        }

        return null;
    }


    private List<GameEnum> gameSelectedGameTypes() {
        List<GameEnum> gameTypes = new ArrayList<>();

        if (this.ticTacToeCheckbox.isSelected()) {
            gameTypes.add(GameEnum.TIC_TAC_TOE);
        }

        if (this.connectFourCheckbox.isSelected()) {
            gameTypes.add(GameEnum.CONNECT_FOUR);
        }

        if (this.cookieClickerCheckbox.isSelected()) {
            gameTypes.add(GameEnum.COOKIE_CLICKER);
        }
        if (this.runnerCheckbox.isSelected()) {
            gameTypes.add(GameEnum.RUNNER);
        }

        return gameTypes;
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
