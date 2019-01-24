package Player;

import Repository.Player.PlayerStatsEnum;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Map;

public interface Player extends Serializable {
    public Color getColor();

    public String getName();

    public ImageIcon getIcon();

    public Map<PlayerStatsEnum, String> getStats();
}
