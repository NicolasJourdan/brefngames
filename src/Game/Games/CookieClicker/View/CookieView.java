package Game.Games.CookieClicker.View;

import Parameter.Model.ThemeEnum;
import Player.Player;
import Repository.Parameter.ThemeParameterRepository;
import Scene.Model.ActionEnum;
import Utils.UI.CustomLabel;
import Utils.UI.CustomPanel.CustomGameBackgroundPanel;
import Utils.UI.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class CookieView extends CustomGameBackgroundPanel {

    private static String ACTION_PRESS_Q = "ACTION_PRESS_Q";
    private static String ACTION_RELEASE_Q = "ACTION_RELEASE_Q";
    private static String ACTION_PRESS_M = "ACTION_PRESS_M";
    private static String ACTION_RELEASE_M = "ACTION_RELEASE_M";
    private static String ACTION_PRESS_S = "ACTION_PRESS_S";
    private static String ACTION_PRESS_L = "ACTION_PRESS_L";

    public static final int WIDTH_COOKIE = 300;
    public static final int HEIGHT_COOKIE = 300;

    private static Icon DEFAULT_SMALL_COOKIE = new ImageIcon(CookieView.class.getResource("/data/Images/cookieSmall.png"));
    private static Icon DEFAULT_BIG_COOKIE = new ImageIcon(CookieView.class.getResource("/data/Images/cookieBig.png"));

    private JLabel firstPlayerButton;
    private JLabel secondPlayerButton;
    private CustomLabel firstPlayerCheck;
    private CustomLabel secondPlayerCheck;
    private CustomLabel commandFirstPlayer;
    private CustomLabel commandSecondPlayer;
    private CustomLabel goalScreen;

    public CookieView(Player[] players, int[] scores){
        super(players, scores);
        this.setLayout(new GridBagLayout());
        this.setFocusable(true);
        this.requestFocus();
        this.initComponent();
        this.setVisible(true);
        this.revalidate();
        this.repaint();

        // press Q
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0, false), ACTION_PRESS_Q);

        // release Q
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0, true), ACTION_RELEASE_Q);

        // press M
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_M, 0, false), ACTION_PRESS_M);

        // release M
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_M, 0, true), ACTION_RELEASE_M);

        // press S
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), ACTION_PRESS_S);

        // press L
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_L, 0, false), ACTION_PRESS_L);


        this.getActionMap().put(ACTION_PRESS_Q, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CookieView.this.firstPlayerButton.setIcon(DEFAULT_SMALL_COOKIE);
                repaint();
                revalidate();
            }
        });

        this.getActionMap().put(ACTION_RELEASE_Q, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CookieView.this.firstPlayerButton.setIcon(DEFAULT_BIG_COOKIE);
                repaint();
                revalidate();
                CookieView.this.observable.notifyObservers(ActionEnum.ADD_COOKIE_FIRST_PLAYER);
            }
        });

        this.getActionMap().put(ACTION_PRESS_M, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CookieView.this.secondPlayerButton.setIcon(DEFAULT_SMALL_COOKIE);
                repaint();
                revalidate();
            }
        });

        this.getActionMap().put(ACTION_RELEASE_M, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CookieView.this.secondPlayerButton.setIcon(DEFAULT_BIG_COOKIE);
                repaint();
                revalidate();
                CookieView.this.observable.notifyObservers(ActionEnum.ADD_COOKIE_SECOND_PLAYER);
            }
        });

        this.getActionMap().put(ACTION_PRESS_S, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CookieView.this.observable.notifyObservers(ActionEnum.CHECK);
            }
        });

        this.getActionMap().put(ACTION_PRESS_L, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CookieView.this.observable.notifyObservers(ActionEnum.CHECK);
            }
        });
    }

    private void initComponent(){
        GridBagConstraints constraint = new GridBagConstraints();

        Dimension dimCookie = new Dimension(WIDTH_COOKIE, HEIGHT_COOKIE);

        this.goalScreen = new CustomLabel("GOAL");
        this.goalScreen.setForeground((Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue());
        this.goalScreen.setFont(goalScreen.getFont().deriveFont(Utils.DEFAULT_GOAL_SIZE_LABEL));

        this.firstPlayerButton = new JLabel(DEFAULT_BIG_COOKIE);
        this.firstPlayerButton.setFocusable(false);
        this.firstPlayerButton.setPreferredSize(dimCookie);
        this.firstPlayerButton.setOpaque(false);

        this.secondPlayerButton = new JLabel(DEFAULT_BIG_COOKIE);
        this.secondPlayerButton.setFocusable(false);
        this.secondPlayerButton.setPreferredSize(dimCookie);
        this.secondPlayerButton.setOpaque(false);

        this.firstPlayerCheck = new CustomLabel("Validate tap 'S'");
        this.firstPlayerCheck.setFont(firstPlayerCheck.getFont().deriveFont(Utils.DEFAULT_SIZE_TITLE_LABEL));
        this.secondPlayerCheck = new CustomLabel("Validate tap 'L'");
        this.secondPlayerCheck.setFont(secondPlayerCheck.getFont().deriveFont(Utils.DEFAULT_SIZE_TITLE_LABEL));

        this.commandFirstPlayer = new CustomLabel("Press Q");
        this.commandSecondPlayer = new CustomLabel("Press M");

        constraint.gridy = 0;
        constraint.gridx = 2;
        constraint.gridwidth = 2;
        this.add(this.scoreDisplay, constraint);

        constraint.gridy = 1;
        constraint.gridx = 2;
        constraint.gridwidth = 1;
        this.add(firstPlayerButton, constraint);

        constraint.gridy = 1;
        constraint.gridx = 3;
        this.add(secondPlayerButton, constraint);

        constraint.gridy = 2;
        constraint.gridx = 2;
        this.add(commandFirstPlayer, constraint);

        constraint.gridy = 2;
        constraint.gridx = 3;
        this.add(commandSecondPlayer, constraint);

        constraint.gridy = 3;
        constraint.gridx = 2;
        this.add(firstPlayerCheck, constraint);

        constraint.gridy = 3;
        constraint.gridx = 3;
        this.add(secondPlayerCheck, constraint);

        constraint.gridy = 4;
        constraint.gridx = 2;
        constraint.gridwidth = 2;
        this.add(goalScreen, constraint);
    }

    public void setGoalScreen(int goal) {
        this.goalScreen.setText("GOAL : " + goal);
        this.revalidate();
        this.repaint();
    }
}
