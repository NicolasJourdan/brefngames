package Map.Model;

import Player.Player;
import Scene.Model.ActionEnum;
import Scene.Model.SceneEnum;

import java.io.Serializable;

public class GameHistory implements Serializable {

    private SceneEnum gameName;

    private Player winner;

    /**
     * @param gameName The game name
     * @param players The player list
     * @param result The result of the match (FIRST_PLAYER_WON, SECOND_PLAYER_WON, DRAW, UNDEFINED)
     */
    public GameHistory(SceneEnum gameName, Player[] players, ActionEnum result) {
        this.gameName = gameName;
        switch (result) {
            case FIRST_PLAYER_WON:
                this.winner = players[0];
                break;
            case SECOND_PLAYER_WON:
                this.winner = players[1];
                break;
            case DRAW:
            case UNDEFINED:
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

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
