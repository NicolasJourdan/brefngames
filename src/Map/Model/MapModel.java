package Map.Model;

import Game.Model.AbstractGameModel;
import Player.*;
import Statistic.Model.Statistic;

import java.util.List;

public class MapModel extends AbstractGameModel {

    public MapModel(Player[] listPlayers) {
        super(listPlayers);
    }

    public int[] getCurrentScore(History history) {
        Player[] players = history.getPlayers();
        int firstPlayerScore = 0;
        int secondPlayerScore = 0;
        for(GameHistory current : history.getGameHistories()) {
            if (null == current.getWinner()) {
                firstPlayerScore++;
                secondPlayerScore++;
            } else if (current.getWinner().equals(players[0])) {
                firstPlayerScore++;
            } else {
                secondPlayerScore++;
            }
        }

        return new int[]{firstPlayerScore, secondPlayerScore};
    }

    public boolean isFinish(History history) {
        return 0 == history.getNbRemainingGames();
    }

    @Override
    public List<Statistic> getListStatistics() {
        return null;
    }
}
