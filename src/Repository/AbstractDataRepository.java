package Repository;

import Repository.AbstractRepository;
import org.json.simple.JSONObject;

public abstract class AbstractDataRepository extends AbstractRepository {
    // Change the path here if you have an error
    //protected static final String DATA_JSON_FILE = "src/data/JSON/jsondata.json";
    protected static final String DATA_JSON_FILE = "src/data/JSON/jsondata.json"; // String Bastos

    protected static JSONObject getDataFile() {
        return getFile(DATA_JSON_FILE);
    }
}
