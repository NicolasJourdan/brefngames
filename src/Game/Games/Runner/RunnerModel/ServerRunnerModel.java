package Game.Games.Runner.RunnerModel;

import Contest.Model.ContestDataPersistor;
import Player.Player;

import java.util.Map;

public class ServerRunnerModel extends RunnerModel {
    public ServerRunnerModel(Player[] listPlayers) {
        super(listPlayers);
    }

    public void saveLocalStatistics() {
        Map firstPlayerStatisticsMap = this.gatherFirstPlayerStatistics();
        ContestDataPersistor.updateDataPlayer(
                this.listPlayers[0].getName(),
                firstPlayerStatisticsMap
        );

        Map statisticsMap = this.gatherStatistics();
        ContestDataPersistor.updateRunner(statisticsMap);
    }

    public Map getStatistics() {
        return this.gatherStatistics();
    }

    public Map getOnlinePlayerStatistics() {
        return this.gatherSecondPlayerStatistics();
    }
}
