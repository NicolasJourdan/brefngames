package Repository.Parameter;

import Parameter.Parameters.ColorParameter;
import Parameter.Model.DefaultPlayerParameterEnum;
import Parameter.Parameters.IconParameter;
import Repository.ModifyFiles;
import org.json.simple.JSONObject;

public class DefaultPlayerParameterRepository extends AbstractParameterRepository {

    public static final String DEFAULT_COLOR_FIELD = "color";
    public static final String DEFAULT_ICON_FIELD = "icon";

    public static ColorParameter getColorFromPlayer(DefaultPlayerParameterEnum playerEnum) {
        JSONObject player = getPlayer(playerEnum);
        String color = (String) player.get(DEFAULT_COLOR_FIELD);
        return new ColorParameter(ColorParameter.getColorFromString(color), color);
    }

    public static IconParameter getIconFromPlayer(DefaultPlayerParameterEnum playerEnum) {
        JSONObject player = getPlayer(playerEnum);
        String iconName = (String) player.get(DEFAULT_ICON_FIELD);
        return new IconParameter(IconParameter.getImageFromString(iconName), iconName);
    }

    public static void save(DefaultPlayerParameterEnum player, String field, String value) {
        if (!field.equals(DEFAULT_COLOR_FIELD) && !field.equals(DEFAULT_ICON_FIELD)) {
            throw new RuntimeException("The filed : " + field + " is unknown");
        }

        // Create a copy
        ModifyFiles.saveJSONFile(PARAMETERS_JSON_FILE);

        JSONObject playerJSON = getPlayer(player);
        playerJSON.put(field, value);

        JSONObject defaultPlayersJSON = getDefaultPlayers();
        switch (player) {
            case PLAYER_1:
                defaultPlayersJSON.put("player1", playerJSON);
                break;
            case PLAYER_2:
                defaultPlayersJSON.put("player2", playerJSON);
                break;
        }

        JSONObject parametersFilesJSON = getParametersFile();
        parametersFilesJSON.put("defaultPlayers", defaultPlayersJSON);

        ModifyFiles.write(PARAMETERS_JSON_FILE, parametersFilesJSON);
    }

    private static JSONObject getDefaultPlayers() {
        return (JSONObject) getParametersFile().get("defaultPlayers");
    }

    private static JSONObject getPlayer(DefaultPlayerParameterEnum defaultPlayerParameterEnum) {
        JSONObject defaultPlayers = getDefaultPlayers();
        if (null == defaultPlayers) {
            throw new RuntimeException("DefaultPlayer is null in parameters.json");
        }

        switch (defaultPlayerParameterEnum) {
            case PLAYER_1:
                return (JSONObject) defaultPlayers.get("player1");
            case PLAYER_2:
                return (JSONObject) defaultPlayers.get("player2");
            default:
                throw new RuntimeException("The theme enum : " + defaultPlayerParameterEnum + " is not acceptable here");
        }
    }
}
