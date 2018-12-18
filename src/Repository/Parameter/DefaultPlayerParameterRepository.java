package Repository.Parameter;

import Parameter.Factory.ColorFactory;
import Parameter.Factory.IconFactory;
import Parameter.Parameters.ColorParameter;
import Parameter.Model.DefaultPlayerParameterEnum;
import Parameter.Parameters.IconParameter;
import Repository.ModifyFiles;
import org.json.simple.JSONObject;

public class DefaultPlayerParameterRepository extends AbstractParameterRepository {

    public static final String DEFAULT_COLOR_FIELD = "color";
    public static final String DEFAULT_ICON_FIELD = "icon";
    public static final String DEFAULT_NODE = "defaultPlayers";
    public static final String DEFAULT_FIRST_FIELD = "player1";
    public static final String DEFAULT_SECOND_FIELD = "player2";

    public static ColorParameter getColorFromPlayer(DefaultPlayerParameterEnum playerEnum) {
        JSONObject player = DefaultPlayerParameterRepository.getPlayer(playerEnum);
        String color = (String) player.get(DEFAULT_COLOR_FIELD);
        return new ColorParameter(ColorFactory.getColor(color), color);
    }

    public static IconParameter getIconFromPlayer(DefaultPlayerParameterEnum playerEnum) {
        JSONObject player = DefaultPlayerParameterRepository.getPlayer(playerEnum);
        String iconName = (String) player.get(DEFAULT_ICON_FIELD);
        return new IconParameter(IconFactory.getIcon(iconName), iconName);
    }

    public static void save(DefaultPlayerParameterEnum player, String field, String value) {
        if (!field.equals(DEFAULT_COLOR_FIELD) && !field.equals(DEFAULT_ICON_FIELD)) {
            throw new RuntimeException("The filed : " + field + " is unknown");
        }

        // Create a copy
        ModifyFiles.saveJSONFile(PARAMETERS_JSON_FILE);

        JSONObject playerJSON = DefaultPlayerParameterRepository.getPlayer(player);
        playerJSON.put(field, value);

        JSONObject defaultPlayersJSON = DefaultPlayerParameterRepository.getDefaultPlayers();
        switch (player) {
            case PLAYER_1:
                defaultPlayersJSON.put(DEFAULT_FIRST_FIELD, playerJSON);
                break;
            case PLAYER_2:
                defaultPlayersJSON.put(DEFAULT_SECOND_FIELD, playerJSON);
                break;
        }

        JSONObject parametersFilesJSON = getParametersFile();
        parametersFilesJSON.put(DEFAULT_NODE, defaultPlayersJSON);

        ModifyFiles.write(PARAMETERS_JSON_FILE, parametersFilesJSON);
    }

    private static JSONObject getDefaultPlayers() {
        return (JSONObject) getParametersFile().get(DEFAULT_NODE);
    }

    private static JSONObject getPlayer(DefaultPlayerParameterEnum defaultPlayerParameterEnum) {
        JSONObject defaultPlayers = DefaultPlayerParameterRepository.getDefaultPlayers();
        if (null == defaultPlayers) {
            throw new RuntimeException("DefaultPlayer is null in parameters.json");
        }

        switch (defaultPlayerParameterEnum) {
            case PLAYER_1:
                return (JSONObject) defaultPlayers.get(DEFAULT_FIRST_FIELD);
            case PLAYER_2:
                return (JSONObject) defaultPlayers.get(DEFAULT_SECOND_FIELD);
            default:
                throw new RuntimeException("The theme enum : " + defaultPlayerParameterEnum + " is not acceptable here");
        }
    }
}
