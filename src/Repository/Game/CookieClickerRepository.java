package Repository.Game;

import Game.Games.CookieClicker.CookieClickerStatsEnum;
import Repository.AbstractDataRepository;
import Repository.ModifyFiles;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CookieClickerRepository extends AbstractDataRepository {
    private static final String DEFAULT_NODE = "cookieClicker";
    private static final String NAME = "name";
    private static final String VALUE = "value";

    public static Map<CookieClickerStatsEnum, String> getAll() {
        Map<CookieClickerStatsEnum, String> stats = new HashMap<>();

        JSONArray statsJSONArray = (JSONArray) getDataFile().get(DEFAULT_NODE);
        Iterator<JSONObject> statsIterator = statsJSONArray.iterator();

        while (statsIterator.hasNext()) {
            JSONObject current = statsIterator.next();
            stats.put(CookieClickerStatsEnum.valueOf((String) current.get(NAME)), (String) current.get(VALUE));
        }

        return stats;
    }

    public static String getById(CookieClickerStatsEnum statName) {
        return CookieClickerRepository.getAll().get(statName);
    }

    /**
     * Save ALL the cookie clicker stats
     * @param stats Map with ALL keys
     */
    public static void saveAll(Map<CookieClickerStatsEnum, String> stats) {
        JSONArray statsJSONArray = new JSONArray();
        for (Map.Entry<CookieClickerStatsEnum, String> entry : stats.entrySet()) {
            JSONObject current = new JSONObject();
            current.put(NAME, entry.getKey().toString());
            current.put(VALUE, entry.getValue());
            statsJSONArray.add(current);
        }

        // Create a copy
        ModifyFiles.saveJSONFile(DATA_JSON_FILE);

        JSONObject dataJSON = getDataFile();
        dataJSON.put(DEFAULT_NODE, statsJSONArray);

        ModifyFiles.write(DATA_JSON_FILE, dataJSON);
    }
}
