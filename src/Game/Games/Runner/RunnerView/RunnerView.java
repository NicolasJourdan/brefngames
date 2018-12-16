package Game.Games.Runner.RunnerView;

import Game.Games.ScoreDisplay;
import Game.View.AbstractGameView;
import Map.Model.History;
import Player.Player;
import Scene.Model.ActionEnum;
import Utils.UI.CustomPanel.CustomGameBackgroundPanel;
import Utils.UI.SoundPlayer;
import Utils.UI.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RunnerView extends CustomGameBackgroundPanel {

    private final static String ACTION_PRESS_Q = "ACTION_PRESS_Q";
    private final static String ACTION_PRESS_S = "ACTION_PRESS_S";
    private final static String ACTION_PRESS_L = "ACTION_PRESS_L";
    private final static String ACTION_PRESS_M = "ACTION_PRESS_M";

    private static final int TRACK_INSETS_DIMENSION = 20;
    private static final int CONTROLS_INSETS_DIMENSION = 10;

    private final Track track;
    private final PlayerControls firstPlayerControls;
    private final PlayerControls secondPlayerControls;

    public RunnerView(Player[] players, History history) {
        super(players, history);
        this.setLayout(
            new GridBagLayout()
        );

        // reusable GridBagConstraint to place every needed components
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.gridy = 0;
        constraint.gridx = 0;
        constraint.gridwidth = 2;
        constraint.insets = new Insets(0,0,10,0);
        this.add(this.scoreDisplay, constraint);

        // track
        constraint.gridy = 1;
        constraint.gridheight = 1;
        constraint.insets.top = RunnerView.TRACK_INSETS_DIMENSION;
        constraint.insets.bottom = RunnerView.TRACK_INSETS_DIMENSION;
        this.track = new Track(players);
        this.add(track, constraint);

        // first player controls
        constraint.gridx = 0;
        constraint.gridy = 2;
        constraint.gridwidth = 1;
        constraint.insets.top = RunnerView.CONTROLS_INSETS_DIMENSION;
        constraint.insets.left = RunnerView.CONTROLS_INSETS_DIMENSION;
        constraint.insets.right = RunnerView.CONTROLS_INSETS_DIMENSION;
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
        this.playSound();
    }

    public void updateSecondPlayerNextKey(boolean isNextKeyLeft) {
        this.secondPlayerControls.updateNextKey(isNextKeyLeft);
        this.playSound();
    }

    private void playSound() {
        SoundPlayer.playSound(Utils.DEFAULT_CLICK_SOUND);
    }
}
