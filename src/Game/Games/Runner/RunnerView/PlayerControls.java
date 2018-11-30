package Game.Games.Runner.RunnerView;

import Player.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerControls extends JPanel {

    private static Color ACTIVE_CONTROL_BACKGROUND = Color.DARK_GRAY;
    private static Color ACTIVE_CONTROL_TEXT_COLOR = Color.WHITE;
    private static Color INACTIVE_CONTROL_BACKGROUND = Color.LIGHT_GRAY;
    private static Color INACTIVE_CONTROL_TEXT_COLOR = Color.BLACK;

    private final JLabel playerIcon;
    private final JLabel leftKey;
    private final JLabel rightKey;

    public PlayerControls(ControlsTypeEnum controlsType, Player player) {
        this.setLayout(
            new GridBagLayout()
        );

        // reusable GridBagConstraint to place every needed components
        GridBagConstraints constraint = new GridBagConstraints();

        // player icon
        constraint.gridy = 0;
        constraint.gridx = 0;
        constraint.gridwidth = 2;
        constraint.gridheight = 1;
        this.playerIcon = new JLabel(
            player.getIcon()
        );
        this.add(this.playerIcon, constraint);

        // controls display
        constraint.gridy = 1;
        constraint.gridwidth = 1;
        this.leftKey = new VirtualKey(
            ControlsTypeEnum.A_Z == controlsType ? "A" : "R",
            PlayerControls.ACTIVE_CONTROL_BACKGROUND,
            PlayerControls.ACTIVE_CONTROL_TEXT_COLOR
        );
        this.add(this.leftKey, constraint);

        constraint.gridx = 2;
        this.rightKey = new VirtualKey(
            ControlsTypeEnum.A_Z == controlsType ? "Z" : "T",
            PlayerControls.INACTIVE_CONTROL_BACKGROUND,
            PlayerControls.INACTIVE_CONTROL_TEXT_COLOR
        );
        this.add(this.rightKey, constraint);
    }
}
