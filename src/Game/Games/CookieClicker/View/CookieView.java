package Game.Games.CookieClicker.View;

import Game.View.AbstractGameView;
import Scene.Model.ActionEnum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CookieView extends AbstractGameView implements KeyListener {

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
        this.setLayout(new GridLayout(3,2));
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocus();
        this.initComposant();
        this.setVisible(true);
        this.revalidate();
        this.repaint();

        // press Q
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0, false),
                ACTION_PRESS_Q
        );

        // release Q
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0, true),
                ACTION_RELEASE_Q
        );

        // press M
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_M, 0, false),
                ACTION_PRESS_M
        );

        // release M
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_M, 0, true),
                ACTION_RELEASE_M
        );

        // press S
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false),
                ACTION_PRESS_S
        );

        // press L
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_L, 0, false),
                ACTION_PRESS_L
        );


        this.getActionMap().put(ACTION_PRESS_Q, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO:
            }
        });

        this.getActionMap().put(ACTION_RELEASE_Q, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO:
            }
        });

        this.getActionMap().put(ACTION_PRESS_M, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO:
            }
        });

        this.getActionMap().put(ACTION_RELEASE_M, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO:
            }
        });

        this.getActionMap().put(ACTION_PRESS_S, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO:
            }
        });

        this.getActionMap().put(ACTION_PRESS_L, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO:
            }
        });
    }

    private void initComposant(){
        Font police = new Font("Arial", Font.BOLD, 20);
        Font police2 = new Font("Arial", Font.BOLD, 80);
        Dimension dim = new Dimension(225, 225);

        this.goalScreen = new JLabel("GOAL");
        this.goalScreen.setFont(police);
        this.goalScreen.setForeground(Color.RED);
        this.goalScreen.setHorizontalAlignment(JLabel.RIGHT);

        this.firstPlayerButton = new JButton(DEFAULT_BIG_COOKIE);
        this.firstPlayerButton.setFont(police2);
        this.firstPlayerButton.setPreferredSize(dim);
        this.firstPlayerButton.setPreferredSize(dim);

        this.secondPlayerButton = new JButton(DEFAULT_BIG_COOKIE);
        this.secondPlayerButton.setFont(police2);
        this.secondPlayerButton.setPreferredSize(dim);
        this.secondPlayerButton.setPreferredSize(dim);

        this.firstPlayerCheck = new JButton("Check : S");
        this.firstPlayerCheck.setFont(police);
        this.firstPlayerCheck.setPreferredSize(dim);

        this.secondPlayerCheck = new JButton("Check : L");
        this.secondPlayerCheck.setFont(police);
        this.secondPlayerCheck.setPreferredSize(dim);

        this.add(this.firstPlayerButton);
        this.add(this.secondPlayerButton);
        this.add(this.firstPlayerCheck);
        this.add(this.secondPlayerCheck);
        this.add(this.goalScreen);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int keycode= e.getKeyCode();
        switch (keycode){
            case KeyEvent.VK_Q :
                System.out.println("ici dans Q Typed");
                firstPlayerButton.setIcon(DEFAULT_SMALL_COOKIE);
                repaint();
                revalidate();
                this.observable.notifyObservers(ActionEnum.ADD_COOKIE_P1);
                break;
            case KeyEvent.VK_M :
                System.out.println("ici dans M Typed");
                secondPlayerButton.setIcon(DEFAULT_SMALL_COOKIE);
                repaint();
                revalidate();
                this.observable.notifyObservers(ActionEnum.ADD_COOKIE_P2);
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keycode= e.getKeyCode();
        switch (keycode){
            case KeyEvent.VK_Q :
                System.out.println("ici dans Q released");
                firstPlayerButton.setIcon(DEFAULT_BIG_COOKIE);
                repaint();
                revalidate();
                this.observable.notifyObservers(ActionEnum.ADD_COOKIE_P1);
                break;
            case KeyEvent.VK_M :
                System.out.println("ici dans M released");
                secondPlayerButton.setIcon(DEFAULT_BIG_COOKIE);
                repaint();
                revalidate();
                this.observable.notifyObservers(ActionEnum.ADD_COOKIE_P2);
                break;
            case KeyEvent.VK_S :
            case KeyEvent.VK_L :
                System.out.println("ici dans L ou S released");
                this.observable.notifyObservers(ActionEnum.CHECK);
                break;
        }
    }

    public void setGoalScreen(int goal) {
        this.goalScreen.setText("GOAL : " + goal);
    }
}
