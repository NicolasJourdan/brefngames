package Game.Games.Runner.RunnerView;

import Game.View.AbstractGameView;
import Player.Player;

import java.awt.*;

public class RunnerView extends AbstractGameView {

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
        this.track = new Track();
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
    }
}
