package ContestSettings.View;

import Scene.Model.ActionEnum;
import Structure.AbstractView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContestSettingsView extends AbstractView {

    public final static int NB_MAX_GAMES = 10;
    public final static int NB_MIN_GAMES = 1;
    public final static int NB_DEFAULT_GAMES = 4;
    public final static int NB_STEP_GAMES = 1;

    public final static String DEFAULT_PLAYER1_NAME = "Player 1";
    public final static String DEFAULT_PLAYER2_NAME = "Player 2";

    private final JCheckBox ticTacToeCheckbox;
    private final JCheckBox connectFourCheckbox;
    private final JCheckBox cookieClickerCheckbox;
    private final JCheckBox runnerCheckbox;
    private final JSpinner spinnerNbGames;

    private final JTextField player1Name;
    private final JTextField player2Name;

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
        this.cookieClickerCheckbox = new JCheckBox("Cookie Clicker");
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
        JPanel player1Panel = new JPanel();
        player1Panel.setLayout(new GridBagLayout());
        player1Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        player1Panel.add(new JLabel("Player 1"), constraintPlayerPanel);

        constraintPlayerPanel.gridx = 1;
        this.player1Name = new JTextField(ContestSettingsView.DEFAULT_PLAYER1_NAME);
        player1Panel.add(this.player1Name, constraintPlayerPanel);

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
        player1Panel.add(firstIconGroupPanel, constraintPlayerPanel);

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
        player1Panel.add(firstColorGroupPanel, constraintPlayerPanel);

        this.add(player1Panel, constraint);

        // Player 2
        JPanel player2Panel = new JPanel();
        player2Panel.setLayout(new GridBagLayout());
        player2Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        constraintPlayerPanel.gridx = 0;
        constraintPlayerPanel.gridy = 0;
        player2Panel.add(new JLabel("Player 2"), constraintPlayerPanel);

        constraintPlayerPanel.gridx = 1;
        this.player2Name = new JTextField(ContestSettingsView.DEFAULT_PLAYER2_NAME);
        player2Panel.add(this.player2Name, constraintPlayerPanel);

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
        player2Panel.add(secondIconGroupPanel, constraintPlayerPanel);

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
        player2Panel.add(secondColorGroupPanel, constraintPlayerPanel);

        constraint.gridy = 3;
        this.add(player2Panel, constraint);

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
    }
}
