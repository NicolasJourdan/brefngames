package Repository.Parameter;

import Parameter.Factory.ColorFactory;
import Parameter.Model.ThemeEnum;
import Parameter.Parameters.ColorParameter;
import Repository.ModifyFiles;
import org.json.simple.JSONObject;

public class ThemeParameterRepository extends AbstractParameterRepository {

    public static final String DEFAULT_SECOND_COLOR_FIELD = "secondColor";
    public static final String DEFAULT_FIRST_COLOR_FIELD = "firstColor";
    public static final String DEFAULT_FIRST_THEME_COLOR_FIELD = "firstColor";
    public static final String DEFAULT_SECOND_THEME_COLOR_FIELD = "secondColor";
    public static final String DEFAULT_NODE = "theme";

    public static ColorParameter getColor(ThemeEnum themeColor) {
        String color = ThemeParameterRepository.getThemeColor(themeColor);
        return new ColorParameter(ColorFactory.getColor(color), color);
    }

    private static JSONObject getTheme() {
        return (JSONObject) getParametersFile().get(DEFAULT_NODE);
    }

    private static String getThemeColor(ThemeEnum themeEnum) {
        JSONObject theme = getTheme();
        if (null == theme) {
            throw new RuntimeException("Theme is null in parameters.json");
        }

        switch (themeEnum) {
            case FIRST_COLOR:
                return (String) theme.get(DEFAULT_FIRST_THEME_COLOR_FIELD);
            case SECOND_COLOR:
                return (String) theme.get(DEFAULT_SECOND_THEME_COLOR_FIELD);
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
        parametersFilesJSON.put(DEFAULT_NODE, themeJSON);

        ModifyFiles.write(PARAMETERS_JSON_FILE, parametersFilesJSON);
    }
}
