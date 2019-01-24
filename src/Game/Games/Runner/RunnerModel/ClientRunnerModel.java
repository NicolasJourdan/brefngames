package Game.Games.Runner.RunnerModel;

import Contest.Model.ContestDataPersistor;
import Player.Player;

import java.util.Map;

public class ClientRunnerModel extends RunnerModel {
    public ClientRunnerModel(Player[] listPlayers) {
        super(listPlayers);
    }

    private String getLocalPlayerName() {
        return this.listPlayers[1].getName();
    }

    public void saveLocalStatistics(Map statisticsMap) {
        ContestDataPersistor.updateRunner(statisticsMap);
    }

    public void saveLocalPlayerStatistcs(Map localPlayerStatisticsMap) {
        ContestDataPersistor.updateDataPlayer(
                this.getLocalPlayerName(),
                localPlayerStatisticsMap
        );
    }
}
