package Repository.Parameter;

import Parameter.Parameters.SoundParameter;
import Repository.ModifyFiles;
import org.json.simple.JSONObject;

public class SoundParameterRepository extends AbstractParameterRepository {

    public static SoundParameter getSound() {
        return new SoundParameter((boolean) getParametersFile().get("sound"));
    }

    public static void save(boolean value) {
        // Create a copy
        ModifyFiles.saveJSONFile(PARAMETERS_JSON_FILE);

        JSONObject parametersFilesJSON = getParametersFile();
        parametersFilesJSON.put("sound", value);

        ModifyFiles.write(PARAMETERS_JSON_FILE, parametersFilesJSON);
    }
}
