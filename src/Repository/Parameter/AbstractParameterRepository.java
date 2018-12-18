package Repository.Parameter;

import Repository.AbstractRepository;
import org.json.simple.JSONObject;

public abstract class AbstractParameterRepository extends AbstractRepository {

    // Change the path here if you have an error
    protected static final String PARAMETERS_JSON_FILE = "src/data/JSON/parameters.json";

    protected static JSONObject getParametersFile() {
        return getFile(PARAMETERS_JSON_FILE);
    }
}
