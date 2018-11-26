package Map.Model;

import Player.Player;
import Scene.Model.ActionEnum;
import Scene.Model.SceneEnum;

public class GameHistory {

    private SceneEnum gameName;

    private Player winner;

    /**
     * @param gameName The game name
     * @param players The player list
     * @param result The result of the match (PLAYER_1_WON, PLAYER_2_WON, DRAW)
     */
    public GameHistory(SceneEnum gameName, Player[] players, ActionEnum result) {
        this.gameName = gameName;
        switch (result) {
            case PLAYER_1_WON:
                this.winner = players[0];
                break;
            case PLAYER_2_WON:
                this.winner = players[1];
                break;
            case DRAW:
                this.winner = null;
                break;
            default:
                throw new RuntimeException("Bad result : " + result);
        }
    }

    public SceneEnum getGameName() {
        return gameName;
    }

    public Player getWinner() {
        return winner;
    }
}
