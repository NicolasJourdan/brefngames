package Player;

import Repository.Player.PlayerStatsEnum;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class LocalPlayer extends AbstractPlayer {
    public LocalPlayer(String name, Color color, ImageIcon icon, Map<PlayerStatsEnum, String> stats) {
        super(name, color, icon, stats);
    }
}
