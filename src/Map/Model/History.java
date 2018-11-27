package Map.Model;

import Player.*;

import java.util.List;

public class History {

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
}
