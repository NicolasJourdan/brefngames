package Map.Model;

import Scene.Model.SceneEnum;

import java.util.List;

public class History {

    private List<GameHistory> gameHistories;

    private SceneEnum currentGame;

    private int nbTotalGames;

    public History(List<GameHistory> gameHistories, SceneEnum currentGame, int nbTotalGames) {
        this.gameHistories = gameHistories;
        this.currentGame = currentGame;
        this.nbTotalGames = nbTotalGames;
    }

    public List<GameHistory> getGameHistories() {
        return gameHistories;
    }

    public SceneEnum getCurrentGame() {
        return currentGame;
    }

    public int getNbTotalGames() {
        return nbTotalGames;
    }
}
