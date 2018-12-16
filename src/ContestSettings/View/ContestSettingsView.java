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
import Utils.UI.*;
import Utils.UI.CustomPanel.CustomBackgroundPanel;
import Utils.UI.CustomPanel.CustomGreyPanel;
import Utils.UI.CustomSpinner.CustomSpinner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContestSettingsView extends CustomBackgroundPanel {

    public final static int NB_MAX_GAMES = 7;
    public final static int NB_MIN_GAMES = 1;
    public final static int NB_DEFAULT_GAMES = 4;
    public final static int NB_STEP_GAMES = 1;

    public final static String DEFAULT_FIRST_PLAYER_NAME = "Player 1";
    public final static String DEFAULT_SECOND_PLAYER_NAME = "Player 2";

    private static final int PANEL_BORDER = 5;
    private static final int TOP_INSET = 8;
    private static final int VERTICAL_INSET = 5;
    private static final int BUTTONS_VERTICAL_INSET = 50;

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

        constraint.fill = GridBagConstraints.BOTH;
        constraint.gridy = 0;
        constraint.gridx = 0;
        constraint.gridwidth = 2;
        constraint.gridheight = 1;
        constraint.insets.left = ContestSettingsView.VERTICAL_INSET;
        constraint.insets.right = ContestSettingsView.VERTICAL_INSET;

        CustomLabel titleLabel = new CustomLabel("Contest customization");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(Utils.DEFAULT_SIZE_TITLE_LABEL));
        this.add(titleLabel, constraint);


        // Game checkboxes
        JPanel gameSelectionPanel = new CustomGreyPanel();
        gameSelectionPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        ContestSettingsView.PANEL_BORDER,
                        ContestSettingsView.PANEL_BORDER,
                        ContestSettingsView.PANEL_BORDER,
                        ContestSettingsView.PANEL_BORDER
                )
        );
        gameSelectionPanel.setLayout(new GridBagLayout());
        GridBagConstraints gameSelectionConstraints = new GridBagConstraints();

        gameSelectionConstraints.anchor = GridBagConstraints.CENTER;
        gameSelectionPanel.add(new CustomLabel("Game type selection"), gameSelectionConstraints);

        gameSelectionConstraints.anchor = GridBagConstraints.WEST;
        gameSelectionConstraints.gridy = 1;
        this.ticTacToeCheckbox = new CustomCheckBox("Tic Tac Toe");
        this.ticTacToeCheckbox.setFont(this.ticTacToeCheckbox.getFont().deriveFont(Utils.DEFAULT_SIZE_SMALL_CONTEST));
        this.ticTacToeCheckbox.setSelected(true);
        gameSelectionPanel.add(this.ticTacToeCheckbox, gameSelectionConstraints);

        gameSelectionConstraints.gridy = 2;
        this.connectFourCheckbox = new CustomCheckBox("Connect Four");
        this.connectFourCheckbox.setFont(this.connectFourCheckbox.getFont().deriveFont(Utils.DEFAULT_SIZE_SMALL_CONTEST));
        this.connectFourCheckbox.setSelected(true);
        gameSelectionPanel.add(this.connectFourCheckbox, gameSelectionConstraints);

        gameSelectionConstraints.gridy = 3;
        this.cookieClickerCheckbox = new CustomCheckBox("Cookie Clicker");
        this.cookieClickerCheckbox.setFont(this.cookieClickerCheckbox.getFont().deriveFont(Utils.DEFAULT_SIZE_SMALL_CONTEST));
        this.cookieClickerCheckbox.setSelected(true);
        gameSelectionPanel.add(this.cookieClickerCheckbox, gameSelectionConstraints);

        gameSelectionConstraints.gridy = 4;
        this.runnerCheckbox = new CustomCheckBox("Runner");
        this.runnerCheckbox.setFont(this.runnerCheckbox.getFont().deriveFont(Utils.DEFAULT_SIZE_SMALL_CONTEST));
        this.runnerCheckbox.setSelected(true);
        gameSelectionPanel.add(this.runnerCheckbox, gameSelectionConstraints);

        constraint.gridy = 1;
        constraint.gridwidth = 1;
        constraint.gridheight = 2;
        constraint.insets.top = ContestSettingsView.TOP_INSET;
        this.add(gameSelectionPanel, constraint);

        // number of matches
        constraint.gridy = 3;
        constraint.gridheight = 1;
        JPanel nbGamesPanel = new CustomGreyPanel();
        nbGamesPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        ContestSettingsView.PANEL_BORDER,
                        ContestSettingsView.PANEL_BORDER,
                        ContestSettingsView.PANEL_BORDER,
                        ContestSettingsView.PANEL_BORDER
                )
        );
        nbGamesPanel.setLayout(new GridLayout(2, 1));

        JLabel nbGamesLabel = new CustomLabel("Number of matches");
        nbGamesLabel.setHorizontalAlignment(JLabel.CENTER);
        nbGamesLabel.setFont(nbGamesLabel.getFont().deriveFont(Utils.DEFAULT_SIZE_SMALL_CONTEST));
        nbGamesPanel.add(nbGamesLabel);
        this.spinnerNbGames = new CustomSpinner(
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
        GridBagConstraints constraintPlayerPanel = new GridBagConstraints();

        // Player 1
        JPanel firstPlayerPanel = new CustomGreyPanel();
        firstPlayerPanel.setLayout(new GridBagLayout());
        firstPlayerPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        ContestSettingsView.PANEL_BORDER,
                        ContestSettingsView.PANEL_BORDER,
                        ContestSettingsView.PANEL_BORDER,
                        ContestSettingsView.PANEL_BORDER
                )
        );
        firstPlayerPanel.add(new CustomLabel("Player 1"), constraintPlayerPanel);

        constraintPlayerPanel.gridy = 1;
        this.firstPlayerName = new CustomTextField(ContestSettingsView.DEFAULT_FIRST_PLAYER_NAME);
        firstPlayerPanel.add(this.firstPlayerName, constraintPlayerPanel);

        this.firstIconSuperman = new CustomRadioButton("Superman");
        this.firstIconSuperman.setFont(this.firstIconSuperman.getFont().deriveFont(Utils.DEFAULT_SIZE_SMALL_CONTEST));
        this.firstIconBatman = new CustomRadioButton("Batman");
        this.firstIconBatman.setFont(this.firstIconBatman.getFont().deriveFont(Utils.DEFAULT_SIZE_SMALL_CONTEST));
        this.firstIconFlash = new CustomRadioButton("Flash");
        this.firstIconFlash.setFont(this.firstIconFlash.getFont().deriveFont(Utils.DEFAULT_SIZE_SMALL_CONTEST));
        this.firstIconAquaman = new CustomRadioButton("Aquaman");
        this.firstIconAquaman.setFont(this.firstIconAquaman.getFont().deriveFont(Utils.DEFAULT_SIZE_SMALL_CONTEST));

        this.firstColorPlayerRed = new CustomRadioButton("Red");
        this.firstColorPlayerRed.setFont(this.firstColorPlayerRed.getFont().deriveFont(Utils.DEFAULT_SIZE_SMALL_CONTEST));
        this.firstColorPlayerBlue = new CustomRadioButton("Blue");
        this.firstColorPlayerBlue.setFont(this.firstColorPlayerBlue.getFont().deriveFont(Utils.DEFAULT_SIZE_SMALL_CONTEST));
        this.firstColorPlayerGreen = new CustomRadioButton("Green");
        this.firstColorPlayerGreen.setFont(this.firstColorPlayerGreen.getFont().deriveFont(Utils.DEFAULT_SIZE_SMALL_CONTEST));
        this.firstColorPlayerYellow = new CustomRadioButton("Yellow");
        this.firstColorPlayerYellow.setFont(this.firstColorPlayerYellow.getFont().deriveFont(Utils.DEFAULT_SIZE_SMALL_CONTEST));

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

        constraint.gridx = 1;
        constraint.gridy = 1;
        constraint.gridwidth = 1;
        this.add(firstPlayerPanel, constraint);

        // Player 2
        JPanel secondPlayerPanel = new CustomGreyPanel();
        secondPlayerPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        ContestSettingsView.PANEL_BORDER,
                        ContestSettingsView.PANEL_BORDER,
                        ContestSettingsView.PANEL_BORDER,
                        ContestSettingsView.PANEL_BORDER
                )
        );
        secondPlayerPanel.setLayout(new GridBagLayout());

        constraintPlayerPanel.gridx = 0;
        constraintPlayerPanel.gridy = 0;
        secondPlayerPanel.add(new CustomLabel("Player 2"), constraintPlayerPanel);

        constraintPlayerPanel.gridy = 1;
        this.secondPlayerName = new CustomTextField(ContestSettingsView.DEFAULT_SECOND_PLAYER_NAME);
        secondPlayerPanel.add(this.secondPlayerName, constraintPlayerPanel);

        this.secondColorPlayerRed = new CustomRadioButton("Red");
        this.secondColorPlayerRed.setFont(this.secondColorPlayerRed.getFont().deriveFont(Utils.DEFAULT_SIZE_SMALL_CONTEST));
        this.secondColorPlayerBlue = new CustomRadioButton("Blue");
        this.secondColorPlayerBlue.setFont(this.secondColorPlayerBlue.getFont().deriveFont(Utils.DEFAULT_SIZE_SMALL_CONTEST));
        this.secondColorPlayerGreen = new CustomRadioButton("Green");
        this.secondColorPlayerGreen.setFont(this.secondColorPlayerGreen.getFont().deriveFont(Utils.DEFAULT_SIZE_SMALL_CONTEST));
        this.secondColorPlayerYellow = new CustomRadioButton("Yellow");
        this.secondColorPlayerYellow.setFont(this.secondColorPlayerYellow.getFont().deriveFont(Utils.DEFAULT_SIZE_SMALL_CONTEST));

        this.secondIconSuperman = new CustomRadioButton("Superman");
        this.secondIconSuperman.setFont(this.secondIconSuperman.getFont().deriveFont(Utils.DEFAULT_SIZE_SMALL_CONTEST));
        this.secondIconBatman = new CustomRadioButton("Batman");
        this.secondIconBatman.setFont(this.secondIconBatman.getFont().deriveFont(Utils.DEFAULT_SIZE_SMALL_CONTEST));
        this.secondIconFlash = new CustomRadioButton("Flash");
        this.secondIconFlash.setFont(this.secondIconFlash.getFont().deriveFont(Utils.DEFAULT_SIZE_SMALL_CONTEST));
        this.secondIconAquaman = new CustomRadioButton("Aquaman");
        this.secondIconAquaman.setFont(this.secondIconAquaman.getFont().deriveFont(Utils.DEFAULT_SIZE_SMALL_CONTEST));

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

        constraint.gridy = 2;
        constraint.gridheight = 2;
        this.add(secondPlayerPanel, constraint);

        // buttons
        JPanel buttonsPanel = new CustomBackgroundPanel();
        buttonsPanel.setLayout(new GridBagLayout());
        GridBagConstraints buttonsGridBagConstraints = new GridBagConstraints();
        buttonsGridBagConstraints.insets.right = ContestSettingsView.BUTTONS_VERTICAL_INSET;
        buttonsGridBagConstraints.insets.left = ContestSettingsView.BUTTONS_VERTICAL_INSET;

        // Back button
        this.backButton = new CustomButton("Back");
        buttonsPanel.add(this.backButton, buttonsGridBagConstraints);

        this.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContestSettingsView.this.observable.notifyObservers(ActionEnum.END_CONTEST);
            }
        });

        // Start button
        this.startButton = new CustomButton("Start");
        buttonsPanel.add(this.startButton, buttonsGridBagConstraints);

        this.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContestSettingsView.this.observable.notifyObservers(ActionEnum.START_CONTEST);
            }
        });

        constraint.gridx = 0;
        constraint.gridy = 4;
        constraint.gridheight = 1;
        constraint.gridwidth = 2;
        this.add(buttonsPanel, constraint);

        // Warning label
        constraint.gridx = 0;
        constraint.gridy = 5;
        constraint.gridwidth = 2;
        this.warningLabel = new WarningLabel("");
        this.warningLabel.setHorizontalAlignment(JLabel.CENTER);
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
