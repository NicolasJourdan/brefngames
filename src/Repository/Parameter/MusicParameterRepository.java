package Repository.Parameter;

import Parameter.Parameters.MusicParameter;
import Repository.ModifyFiles;
import org.json.simple.JSONObject;

public class MusicParameterRepository extends AbstractParameterRepository {
    public static final String DEFAULT_NODE = "music";

    public static MusicParameter getMusic() {
        return new MusicParameter((boolean) getParametersFile().get(DEFAULT_NODE));
    }

    public static void save(boolean value) {
        // Create a copy
        ModifyFiles.saveJSONFile(PARAMETERS_JSON_FILE);

        JSONObject parametersFilesJSON = getParametersFile();
        parametersFilesJSON.put(DEFAULT_NODE, value);

        ModifyFiles.write(PARAMETERS_JSON_FILE, parametersFilesJSON);
    }
}
