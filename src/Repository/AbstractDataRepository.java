package Repository;

import org.json.simple.JSONObject;

public abstract class AbstractDataRepository extends AbstractRepository {
    // Change the path here if you have an error
    protected static final String DATA_JSON_FILE = "src/data/JSON/jsondata.json";
    protected static final String WORDS_JSON_FILE = "src/data/JSON/secretwords.json";

    protected static JSONObject getDataFile() {
        return getFile(AbstractDataRepository.DATA_JSON_FILE);
    }

    protected static JSONObject getWordsFile() {
        return getFile(AbstractDataRepository.WORDS_JSON_FILE);
    }
}
