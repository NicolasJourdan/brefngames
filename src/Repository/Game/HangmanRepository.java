package Repository.Game;

import Game.Games.Hangman.HangmanStatsEnum;
import Repository.AbstractDataRepository;
import Repository.ModifyFiles;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HangmanRepository extends AbstractDataRepository {
    private static final String DEFAULT_NODE = "hangman";
    private static final String NAME = "name";
    private static final String VALUE = "value";

    public static Map<HangmanStatsEnum, String> getAll() {
        Map<HangmanStatsEnum, String> stats = new HashMap<>();

        JSONArray statsJSONArray = (JSONArray) getDataFile().get(DEFAULT_NODE);
        Iterator<JSONObject> statsIterator = statsJSONArray.iterator();

        while (statsIterator.hasNext()) {
            JSONObject current = statsIterator.next();
            stats.put(HangmanStatsEnum.valueOf((String) current.get(NAME)), (String) current.get(VALUE));
        }

        return stats;
    }

    public static String getById(HangmanStatsEnum statName) {
        return HangmanRepository.getAll().get(statName);
    }

    /**
     * Save ALL the hangman stats
     *
     * @param stats Map with ALL keys
     */
    public static void saveAll(Map<HangmanStatsEnum, String> stats) {
        JSONArray statsJSONArray = new JSONArray();
        for (Map.Entry<HangmanStatsEnum, String> entry : stats.entrySet()) {
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
