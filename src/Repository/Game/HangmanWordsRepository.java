package Repository.Game;

import Game.Games.ConnectFour.ConnectFourStatsEnum;
import Repository.AbstractDataRepository;
import org.json.simple.JSONArray;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HangmanWordsRepository extends AbstractDataRepository {
    private static final String DEFAULT_NODE = "words";

    public static String getWord() {
        Map<ConnectFourStatsEnum, String> stats = new HashMap<>();
        JSONArray wordsArray = (JSONArray) getWordsFile().get(HangmanWordsRepository.DEFAULT_NODE);
        Random random = new Random();
        return (String) wordsArray.get(random.nextInt(wordsArray.size()));
    }
}
