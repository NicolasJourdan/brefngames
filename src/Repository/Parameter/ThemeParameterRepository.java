package Repository.Parameter;

import Parameter.Model.ThemeEnum;
import Parameter.Parameters.ColorParameter;
import Repository.ModifyFiles;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ThemeParameterRepository extends AbstractParameterRepository {

    public static final String DEFAULT_SECOND_COLOR_FIELD = "secondColor";
    public static final String DEFAULT_FIRST_COLOR_FIELD = "firstColor";

    public static ColorParameter getColor(ThemeEnum themeColor) {
        String color = getThemeColor(themeColor);
        return new ColorParameter(ColorParameter.getColorFromString(color), color);
    }

    private static JSONObject getTheme() {
        return (JSONObject) getParametersFile().get("theme");
    }

    private static String getThemeColor(ThemeEnum themeEnum) {
        JSONObject theme = getTheme();
        if (null == theme) {
            throw new RuntimeException("Theme is null in parameters.json");
        }

        switch (themeEnum) {
            case FIRST_COLOR:
                return (String) theme.get("firstColor");
            case SECOND_COLOR:
                return (String) theme.get("secondColor");
            default:
                throw new RuntimeException("The theme enum : " + themeEnum + " is not acceptable here");
        }
    }

    public static void save(String field, String value) {
        if (!field.equals(DEFAULT_SECOND_COLOR_FIELD) && !field.equals(DEFAULT_FIRST_COLOR_FIELD)) {
            throw new RuntimeException("The filed : " + field + " is unknown");
        }

        // Create a copy
        ModifyFiles.saveJSONFile(PARAMETERS_JSON_FILE);

        JSONObject themeJSON = getTheme();
        themeJSON.put(field, value);

        JSONObject parametersFilesJSON = getParametersFile();
        parametersFilesJSON.put("theme", themeJSON);

        ModifyFiles.write(PARAMETERS_JSON_FILE, parametersFilesJSON);
    }
}
