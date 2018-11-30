package Player;

import Repository.Player.PlayerStatsEnum;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public interface Player {
    public Color getColor();

    public String getName();

    public ImageIcon getIcon();

    public Map<PlayerStatsEnum, String> getStats();
}
