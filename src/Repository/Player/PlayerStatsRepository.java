package Repository.Player;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PlayerStatsRepository {

    /**
     * Get the statistic map from the JSON Object
     */
    public static Map<PlayerStatsEnum, String> getStatsMap(JSONObject jsonStats) {
        Map<PlayerStatsEnum, String> statsMap = new HashMap<>();

        statsMap.put(PlayerStatsEnum.TIC_TAC_TOE_NB_GAME, (String) jsonStats.get("TIC_TAC_TOE_NB_GAME"));
        statsMap.put(PlayerStatsEnum.TIC_TAC_TOE_NB_WIN, (String) jsonStats.get("TIC_TAC_TOE_NB_WIN"));
        statsMap.put(PlayerStatsEnum.TIC_TAC_TOE_WIN_POURCENT, (String) jsonStats.get("TIC_TAC_TOE_WIN_POURCENT"));
        statsMap.put(PlayerStatsEnum.RUNNER_NB_GAME, (String) jsonStats.get("RUNNER_NB_GAME"));
        statsMap.put(PlayerStatsEnum.RUNNER_NB_WIN, (String) jsonStats.get("RUNNER_NB_WIN"));
        statsMap.put(PlayerStatsEnum.RUNNER_WIN_RATE, (String) jsonStats.get("RUNNER_WIN_RATE"));
        statsMap.put(PlayerStatsEnum.CONNECT_FOUR_NB_GAME, (String) jsonStats.get("CONNECT_FOUR_NB_GAME"));
        statsMap.put(PlayerStatsEnum.CONNECT_FOUR_NB_WIN, (String) jsonStats.get("CONNECT_FOUR_NB_WIN"));
        statsMap.put(PlayerStatsEnum.CONNECT_FOUR_WIN_RATE, (String) jsonStats.get("CONNECT_FOUR_WIN_RATE"));
        statsMap.put(PlayerStatsEnum.COOKIE_CLICKER_NB_GAME, (String) jsonStats.get("COOKIE_CLICKER_NB_GAME"));
        statsMap.put(PlayerStatsEnum.COOKIE_CLICKER_NB_WIN, (String) jsonStats.get("COOKIE_CLICKER_NB_WIN"));
        statsMap.put(PlayerStatsEnum.COOKIE_CLICKER_WIN_RATE, (String) jsonStats.get("COOKIE_CLICKER_WIN_RATE"));
        statsMap.put(PlayerStatsEnum.MOST_PLAYED_GAME, (String) jsonStats.get("MOST_PLAYED_GAME"));
        statsMap.put(PlayerStatsEnum.TOTAL_NB_GAME, (String) jsonStats.get("TOTAL_NB_GAME"));
        statsMap.put(PlayerStatsEnum.TOTAL_NB_WIN, (String) jsonStats.get("TOTAL_NB_WIN"));
        statsMap.put(PlayerStatsEnum.TOTAL_NB_LOOSE, (String) jsonStats.get("TOTAL_NB_LOOSE"));
        statsMap.put(PlayerStatsEnum.WIN_RATE, (String) jsonStats.get("WIN_RATE"));

        return statsMap;
    }

    /**
     * Get the JSON Object from the statistic map
     */
    public static JSONObject getJsonStats(Map<PlayerStatsEnum, String> statsMap) {
        JSONObject jsonStats = new JSONObject();

        jsonStats.put("TIC_TAC_TOE_NB_GAME", statsMap.get(PlayerStatsEnum.TIC_TAC_TOE_NB_GAME));
        jsonStats.put("TIC_TAC_TOE_NB_WIN", statsMap.get(PlayerStatsEnum.TIC_TAC_TOE_NB_WIN));
        jsonStats.put("TIC_TAC_TOE_WIN_POURCENT", statsMap.get(PlayerStatsEnum.TIC_TAC_TOE_WIN_POURCENT));
        jsonStats.put("RUNNER_NB_GAME", statsMap.get(PlayerStatsEnum.RUNNER_NB_GAME));
        jsonStats.put("RUNNER_NB_WIN", statsMap.get(PlayerStatsEnum.RUNNER_NB_WIN));
        jsonStats.put("RUNNER_WIN_RATE", statsMap.get(PlayerStatsEnum.RUNNER_WIN_RATE));
        jsonStats.put("CONNECT_FOUR_NB_GAME", statsMap.get(PlayerStatsEnum.CONNECT_FOUR_NB_GAME));
        jsonStats.put("CONNECT_FOUR_NB_WIN", statsMap.get(PlayerStatsEnum.CONNECT_FOUR_NB_WIN));
        jsonStats.put("CONNECT_FOUR_WIN_RATE", statsMap.get(PlayerStatsEnum.CONNECT_FOUR_WIN_RATE));
        jsonStats.put("COOKIE_CLICKER_NB_GAME", statsMap.get(PlayerStatsEnum.COOKIE_CLICKER_NB_GAME));
        jsonStats.put("COOKIE_CLICKER_NB_WIN", statsMap.get(PlayerStatsEnum.COOKIE_CLICKER_NB_WIN));
        jsonStats.put("COOKIE_CLICKER_WIN_RATE", statsMap.get(PlayerStatsEnum.COOKIE_CLICKER_WIN_RATE));
        jsonStats.put("MOST_PLAYED_GAME", statsMap.get(PlayerStatsEnum.MOST_PLAYED_GAME));
        jsonStats.put("TOTAL_NB_GAME", statsMap.get(PlayerStatsEnum.TOTAL_NB_GAME));
        jsonStats.put("TOTAL_NB_WIN", statsMap.get(PlayerStatsEnum.TOTAL_NB_WIN));
        jsonStats.put("TOTAL_NB_LOOSE", statsMap.get(PlayerStatsEnum.TOTAL_NB_LOOSE));
        jsonStats.put("WIN_RATE", statsMap.get(PlayerStatsEnum.WIN_RATE));

        return jsonStats;
    }
}
