package Game.Games.Runner.RunnerModel;

import Game.Model.AbstractGameModel;
import Player.Player;
import Statistic.Model.Statistic;

import java.util.List;

public class RunnerModel extends AbstractGameModel {
    public RunnerModel(Player[] listPlayers) {
        super(listPlayers);
    }

    @Override
    public List<Statistic> getListStatistics() {
        return null;
    }
}
