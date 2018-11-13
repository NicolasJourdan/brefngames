package Game.Model;

import Parameter.Model.ParameterEnum;
import Player.Player;
import Statistic.Model.Statistic;
import Structure.AbstractModel;

import java.util.List;

/**
 * The game models have to extend this model.
 */
public abstract class AbstractGameModel extends AbstractModel {

    private Player[] listPlayers;

    private List<Statistic> listStatistics;

    public AbstractGameModel(Player[] listPlayers) {
        this.listPlayers = listPlayers;
        this.listStatistics = this.getListStatistics();
    }

    /**
     * Returns an array of all game statistics
     */
    public abstract List<Statistic> getListStatistics();

}
