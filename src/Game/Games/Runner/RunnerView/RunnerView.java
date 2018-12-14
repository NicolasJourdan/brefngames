package Game.Games.Runner.RunnerView;

import Player.Player;
import Scene.Model.ActionEnum;
import Utils.UI.CustomPanel.CustomGameBackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RunnerView extends CustomGameBackgroundPanel {

    private final static String ACTION_PRESS_Q = "ACTION_PRESS_Q";
    private final static String ACTION_PRESS_S = "ACTION_PRESS_S";
    private final static String ACTION_PRESS_L = "ACTION_PRESS_L";
    private final static String ACTION_PRESS_M = "ACTION_PRESS_M";

    private final Track track;
    private final PlayerControls firstPlayerControls;
    private final PlayerControls secondPlayerControls;

    public RunnerView(Player[] players) {
        this.setLayout(
            new GridBagLayout()
        );

        // reusable GridBagConstraint to place every needed components
        GridBagConstraints constraint = new GridBagConstraints();

        // track
        constraint.gridy = 0;
        constraint.gridx = 0;
        constraint.gridwidth = 2;
        constraint.gridheight = 1;
        this.track = new Track(players);
        this.add(track, constraint);

        // first player controls
        constraint.gridx = 0;
        constraint.gridy = 1;
        constraint.gridwidth = 1;
        this.firstPlayerControls = new PlayerControls(ControlsTypeEnum.Q_S, players[0]);
        this.add(this.firstPlayerControls, constraint);

        // second player controls
        constraint.gridx = 1;
        this.secondPlayerControls = new PlayerControls(ControlsTypeEnum.L_M, players[1]);
        this.add(this.secondPlayerControls, constraint);

        this.revalidate();
        this.repaint();

        // key binding

        // press A
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0, false),
                RunnerView.ACTION_PRESS_Q
        );

        this.getActionMap().put(ACTION_PRESS_Q, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RunnerView.this.observable.notifyObservers(ActionEnum.KEY_PRESS_A);
            }
        });

        // press Z
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false),
                RunnerView.ACTION_PRESS_S
        );

        this.getActionMap().put(ACTION_PRESS_S, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RunnerView.this.observable.notifyObservers(ActionEnum.KEY_PRESS_Z);
            }
        });

        // press R
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_L, 0, false),
                RunnerView.ACTION_PRESS_L
        );

        this.getActionMap().put(ACTION_PRESS_L, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RunnerView.this.observable.notifyObservers(ActionEnum.KEY_PRESS_R);
            }
        });

        // press T
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_M, 0, false),
                RunnerView.ACTION_PRESS_M
        );

        this.getActionMap().put(ACTION_PRESS_M, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RunnerView.this.observable.notifyObservers(ActionEnum.KEY_PRESS_T);
            }
        });
    }

    public void setStepsAmount(int stepsAmount) {
        this.track.setStepsAmount(stepsAmount);
    }

    public void updateFirstPlayerPosition(int stepsAmount) {
        this.track.updateFirstPlayerPosition(stepsAmount);
    }

    public void updateSecondPlayerPosition(int stepsAmount) {
        this.track.updateSecondPlayerPosition(stepsAmount);
    }

    public void updateFirstPlayerNextKey(boolean isNextKeyLeft) {
        this.firstPlayerControls.updateNextKey(isNextKeyLeft);
    }

    public void updateSecondPlayerNextKey(boolean isNextKeyLeft) {
        this.secondPlayerControls.updateNextKey(isNextKeyLeft);
    }
}
