package Game.Games.Runner.RunnerView;

import Player.Player;
import Utils.Image.ImageResizer;

import javax.swing.*;
import java.awt.*;

public class PlayerControls extends JPanel {

    private static final int PLAYER_ICON_SIZE = 80;

    private final JLabel playerIcon;
    private final VirtualKey leftKey;
    private final VirtualKey rightKey;

    public PlayerControls(ControlsTypeEnum controlsType, Player player) {
        this.setLayout(
            new GridBagLayout()
        );

        // reusable GridBagConstraint to place every needed components
        GridBagConstraints constraint = new GridBagConstraints();
        this.setOpaque(false);
        // player icon
        constraint.gridy = 0;
        constraint.gridx = 0;
        constraint.gridwidth = 2;
        constraint.gridheight = 1;
        this.playerIcon = new JLabel(
            ImageResizer.resizeImage(player.getIcon(), PlayerControls.PLAYER_ICON_SIZE)
        );
        this.add(this.playerIcon, constraint);

        // controls display
        constraint.gridy = 1;
        constraint.gridwidth = 1;
        this.leftKey = new VirtualKey(
            ControlsTypeEnum.Q_S == controlsType ? "Q" : "L",
            true
        );
        this.add(this.leftKey, constraint);

        constraint.gridx = 2;
        this.rightKey = new VirtualKey(
            ControlsTypeEnum.Q_S == controlsType ? "S" : "M",
            false
        );
        this.add(this.rightKey, constraint);
    }

    public void updateNextKey(boolean isNextKeyLeft) {
        this.leftKey.highlight(isNextKeyLeft);
        this.rightKey.highlight(!isNextKeyLeft);
    }
}
