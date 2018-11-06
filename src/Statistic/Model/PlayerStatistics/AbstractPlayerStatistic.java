package Statistic.Model.PlayerStatistics;

import Player.Player;
import Statistic.Model.AbstractStatistic;

public abstract class AbstractPlayerStatistic extends AbstractStatistic {

    private Player player;

    /**
     * Default constructor
     */
    public AbstractPlayerStatistic(Player player) {
        this.player = player;
    }
}
