package Player;

import Repository.Player.PlayerStatsEnum;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractPlayer implements Player, Serializable {
    protected String name;
    protected Color color;
    protected ImageIcon icon;
    protected Map<PlayerStatsEnum, String> stats;

    public AbstractPlayer(String name, Color color, ImageIcon icon, Map<PlayerStatsEnum, String> stats) {
        this.name = name;
        this.color = color;
        this.icon = icon;
        this.stats = stats;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public Map<PlayerStatsEnum, String> getStats() {
        return this.stats;
    }

    public void setStats(Map<PlayerStatsEnum, String> stats) {
        this.stats = stats;
    }

    public static Map<PlayerStatsEnum, String> initialStatsMap() {
        Map<PlayerStatsEnum, String> statsMap = new HashMap<>();

        statsMap.put(PlayerStatsEnum.TIC_TAC_TOE_NB_GAME, "0");
        statsMap.put(PlayerStatsEnum.TIC_TAC_TOE_NB_WIN, "0");
        statsMap.put(PlayerStatsEnum.TIC_TAC_TOE_WIN_RATE, "0");
        statsMap.put(PlayerStatsEnum.HANGMAN_NB_GAME, "0");
        statsMap.put(PlayerStatsEnum.HANGMAN_NB_WIN, "0");
        statsMap.put(PlayerStatsEnum.HANGMAN_WIN_RATE, "0");
        statsMap.put(PlayerStatsEnum.RUNNER_NB_GAME, "0");
        statsMap.put(PlayerStatsEnum.RUNNER_NB_WIN, "0");
        statsMap.put(PlayerStatsEnum.RUNNER_WIN_RATE, "0");
        statsMap.put(PlayerStatsEnum.CONNECT_FOUR_NB_GAME, "0");
        statsMap.put(PlayerStatsEnum.CONNECT_FOUR_NB_WIN, "0");
        statsMap.put(PlayerStatsEnum.CONNECT_FOUR_WIN_RATE, "0");
        statsMap.put(PlayerStatsEnum.COOKIE_CLICKER_NB_GAME, "0");
        statsMap.put(PlayerStatsEnum.COOKIE_CLICKER_NB_WIN, "0");
        statsMap.put(PlayerStatsEnum.COOKIE_CLICKER_WIN_RATE, "0");
        statsMap.put(PlayerStatsEnum.FIFTEEN_VAINC_NB_GAME, "0");
        statsMap.put(PlayerStatsEnum.FIFTEEN_VAINC_NB_WIN, "0");
        statsMap.put(PlayerStatsEnum.FIFTEEN_VAINC_WIN_RATE, "0");
        statsMap.put(PlayerStatsEnum.MOST_PLAYED_GAME, "NONE");
        statsMap.put(PlayerStatsEnum.TOTAL_NB_GAME, "0");
        statsMap.put(PlayerStatsEnum.TOTAL_NB_WIN, "0");
        statsMap.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "0");
        statsMap.put(PlayerStatsEnum.WIN_RATE, "0");

        return statsMap;
    }
}
