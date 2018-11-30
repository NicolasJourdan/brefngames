package Game.Games.Runner.RunnerView;

import Game.View.AbstractGameView;
import Player.Player;
import Scene.Model.ActionEnum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RunnerView extends AbstractGameView {

    private static String ACTION_PRESS_A = "ACTION_PRESS_A";
    private static String ACTION_PRESS_Z = "ACTION_PRESS_Z";
    private static String ACTION_PRESS_R = "ACTION_PRESS_R";
    private static String ACTION_PRESS_T = "ACTION_PRESS_T";

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
        this.firstPlayerControls = new PlayerControls(ControlsTypeEnum.A_Z, players[0]);
        this.add(this.firstPlayerControls, constraint);

        // second player controls
        constraint.gridx = 1;
        this.secondPlayerControls = new PlayerControls(ControlsTypeEnum.R_T, players[1]);
        this.add(this.secondPlayerControls, constraint);

        this.revalidate();
        this.repaint();

        // key binding

        // press A
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false),
                RunnerView.ACTION_PRESS_A
        );

        this.getActionMap().put(ACTION_PRESS_A, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RunnerView.this.observable.notifyObservers(ActionEnum.KEY_PRESS_A);
            }
        });

        // press Z
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_Z, 0, false),
                RunnerView.ACTION_PRESS_Z
        );

        this.getActionMap().put(ACTION_PRESS_Z, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RunnerView.this.observable.notifyObservers(ActionEnum.KEY_PRESS_Z);
            }
        });

        // press R
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_R, 0, false),
                RunnerView.ACTION_PRESS_R
        );

        this.getActionMap().put(ACTION_PRESS_R, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RunnerView.this.observable.notifyObservers(ActionEnum.KEY_PRESS_R);
            }
        });

        // press T
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_T, 0, false),
                RunnerView.ACTION_PRESS_T
        );

        this.getActionMap().put(ACTION_PRESS_T, new AbstractAction() {
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
}
