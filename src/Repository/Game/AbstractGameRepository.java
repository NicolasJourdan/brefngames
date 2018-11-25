package Repository.Game;

import Repository.AbstractRepository;
import org.json.simple.JSONObject;

public abstract class AbstractGameRepository extends AbstractRepository {
    // Change the path here if you have an error
    protected static final String DATA_JSON_FILE = "src/data/JSON/jsondata.json";

    protected static JSONObject getDataFile() {
        return getFile(DATA_JSON_FILE);
    }
}
