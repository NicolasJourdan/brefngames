package Map.Model;

import Player.*;

import java.io.Serializable;
import java.util.List;

public class History implements Serializable {

    private Player[] players;

    private List<GameHistory> gameHistories;

    private boolean isTraining;

    private int nbRemainingGames;

    private int nbTotalGames;

    public History(Player[] players, List<GameHistory> gameHistories, int nbTotalGames, boolean isTraining) {
        this.isTraining = isTraining;
        this.players = players;
        this.gameHistories = gameHistories;
        this.nbTotalGames = nbTotalGames;
        this.nbRemainingGames = this.nbTotalGames - this.gameHistories.size();
    }

    public void addGameHistory(GameHistory gameHistory) {
        this.gameHistories.add(gameHistory);
        this.nbRemainingGames--;
    }

    public List<GameHistory> getGameHistories() {
        return this.gameHistories;
    }

    public Player[] getPlayers() {
        return this.players;
    }

    public boolean isTraining() {
        return this.isTraining;
    }

    public int getNbRemainingGames() {
        return this.nbRemainingGames;
    }

    public int[] getCurrentScore() {
        int firstPlayerScore = 0;
        int secondPlayerScore = 0;
        for(GameHistory current : this.getGameHistories()) {
            if (null == current.getWinner()) {
                firstPlayerScore++;
                secondPlayerScore++;
            } else if (current.getWinner().equals(this.players[0])) {
                firstPlayerScore++;
            } else {
                secondPlayerScore++;
            }
        }

        return new int[]{firstPlayerScore, secondPlayerScore};
    }
}
