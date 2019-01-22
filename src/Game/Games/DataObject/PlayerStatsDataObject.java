package Game.Games.DataObject;

import Repository.Player.PlayerStatsEnum;

import java.util.Map;

public class PlayerStatsDataObject {

    private String playerId;
    private Map<PlayerStatsEnum, String> stats;

    public PlayerStatsDataObject(String playerId, Map<PlayerStatsEnum, String> stats) {
        this.playerId = playerId;
        this.stats = stats;
    }

    public String getPlayerId() {
        return this.playerId;
    }

    public Map<PlayerStatsEnum, String> getStats() {
        return this.stats;
    }
}
