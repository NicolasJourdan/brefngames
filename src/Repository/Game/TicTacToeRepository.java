package Repository.Game;

import Game.Games.TicTacToe.TicTacToeStatsEnum;
import Repository.AbstractDataRepository;
import Repository.ModifyFiles;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TicTacToeRepository extends AbstractDataRepository {

    private static final String DEFAULT_NODE = "ticTacToe";
    private static final String NAME = "name";
    private static final String VALUE = "value";

    public static Map<TicTacToeStatsEnum, String> getAll() {
            Map<TicTacToeStatsEnum, String> stats = new HashMap<>();

            JSONArray statsJSONArray = (JSONArray) getDataFile().get(DEFAULT_NODE);
            Iterator<JSONObject> statsIterator = statsJSONArray.iterator();

            while (statsIterator.hasNext()) {
                JSONObject current = statsIterator.next();
                stats.put(TicTacToeStatsEnum.valueOf((String) current.get(NAME)), (String) current.get(VALUE));
            }

            return stats;
        }

    public static String getById(TicTacToeStatsEnum statName) {
        return TicTacToeRepository.getAll().get(statName);
    }

    /**
     * Save ALL the tic tac toe stats
     * @param stats Map with ALL keys
     */
    public static void saveAll(Map<TicTacToeStatsEnum, String> stats) {
        JSONArray statsJSONArray = new JSONArray();
        for (Map.Entry<TicTacToeStatsEnum, String> entry : stats.entrySet()) {
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
