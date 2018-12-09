package Game.Games.CookieClicker.View;

import Game.View.AbstractGameView;
import Scene.Model.ActionEnum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class CookieView extends AbstractGameView {

    private static String ACTION_PRESS_Q = "ACTION_PRESS_Q";
    private static String ACTION_RELEASE_Q = "ACTION_RELEASE_Q";
    private static String ACTION_PRESS_M = "ACTION_PRESS_M";
    private static String ACTION_RELEASE_M = "ACTION_RELEASE_M";
    private static String ACTION_PRESS_S = "ACTION_PRESS_S";
    private static String ACTION_PRESS_L = "ACTION_PRESS_L";

    private static Icon DEFAULT_SMALL_COOKIE = new ImageIcon(CookieView.class.getResource("/data/Images/cookieSmall.png"));
    private static Icon DEFAULT_BIG_COOKIE = new ImageIcon(CookieView.class.getResource("/data/Images/cookieBig.png"));

    private JButton firstPlayerButton = new JButton();
    private JButton secondPlayerButton = new JButton();
    private JButton firstPlayerCheck = new JButton();
    private JButton secondPlayerCheck = new JButton();

    private JLabel goalScreen = new JLabel();

    public CookieView(){
        super();
        this.setLayout(new GridBagLayout());
        this.setFocusable(true);
        this.requestFocus();
        this.initComposant();
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

    private void initComposant(){
        GridBagConstraints constraint = new GridBagConstraints();

        Font police = new Font("Arial", Font.BOLD, 20);
        Font police2 = new Font("Arial", Font.BOLD, 30);
        Dimension dim = new Dimension(150, 100);
        Dimension dimCookie = new Dimension(300, 300);

        this.goalScreen = new JLabel("GOAL");
        this.goalScreen.setFont(police2);
        this.goalScreen.setForeground(Color.RED);
        this.goalScreen.setHorizontalAlignment(JLabel.RIGHT);

        this.firstPlayerButton = new JButton(DEFAULT_BIG_COOKIE);
        this.firstPlayerButton.setFont(police2);
        this.firstPlayerButton.setFocusable(false);
        this.firstPlayerButton.setPreferredSize(dimCookie);
        this.firstPlayerButton.setBorderPainted(false);
        this.firstPlayerButton.setContentAreaFilled(false);
        this.firstPlayerButton.setOpaque(false);

        this.secondPlayerButton = new JButton(DEFAULT_BIG_COOKIE);
        this.secondPlayerButton.setFont(police2);
        this.secondPlayerButton.setFocusable(false);
        this.secondPlayerButton.setPreferredSize(dimCookie);
        this.secondPlayerButton.setBorderPainted(false);
        this.secondPlayerButton.setContentAreaFilled(false);
        this.secondPlayerButton.setOpaque(false);

        this.firstPlayerCheck = new JButton("Check : S");
        this.firstPlayerCheck.setFont(police);
        this.firstPlayerCheck.setPreferredSize(dim);
        this.firstPlayerCheck.setBorderPainted(false);
        this.firstPlayerCheck.setContentAreaFilled(false);

        this.secondPlayerCheck = new JButton("Check : L");
        this.secondPlayerCheck.setFont(police);
        this.secondPlayerCheck.setPreferredSize(dim);
        this.secondPlayerCheck.setBorderPainted(false);
        this.secondPlayerCheck.setContentAreaFilled(false);

        constraint.gridy = 0;
        constraint.gridx = 2;
        constraint.gridwidth = 1;
        constraint.gridheight = 1;
        this.add(firstPlayerButton, constraint);

        constraint.gridy = 0;
        constraint.gridx = 3;
        constraint.gridwidth = 1;
        constraint.gridheight = 1;
        this.add(secondPlayerButton, constraint);

        constraint.gridy = 1;
        constraint.gridx = 2;
        constraint.gridwidth = 1;
        constraint.gridheight = 1;
        this.add(firstPlayerCheck, constraint);

        constraint.gridy = 1;
        constraint.gridx = 2;
        constraint.gridwidth = 2;
        constraint.gridheight = 1;
        this.add(goalScreen, constraint);

        constraint.gridy = 1;
        constraint.gridx = 3;
        constraint.gridwidth = 1;
        constraint.gridheight = 1;
        this.add(secondPlayerCheck, constraint);

    }

    public void setGoalScreen(int goal) {
        this.goalScreen.setText("GOAL : " + goal);
        this.revalidate();
        this.repaint();
    }
}
