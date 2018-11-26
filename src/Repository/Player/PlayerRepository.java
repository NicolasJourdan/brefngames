package Repository.Player;

import Parameter.Factory.ColorFactory;
import Player.*;
import Repository.AbstractDataRepository;
import Repository.ModifyFiles;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class PlayerRepository extends AbstractDataRepository {

    // Name of the node where there are all players
    private static final String DEFAULT_NODE = "players";
    // node
    private static final String NAME = "name";
    private static final String COLOR = "color";

    // Get all players in a list of local player
    public static ArrayList<LocalPlayer> getAll() {
        ArrayList<LocalPlayer> listPlayers = new ArrayList<LocalPlayer>();

        JSONArray statsJSONArray = (JSONArray) getDataFile().get(DEFAULT_NODE);
        Iterator<JSONObject> statsIterator = statsJSONArray.iterator();

        while (statsIterator.hasNext()) {
            JSONObject current = statsIterator.next();
            System.out.println(current.get(NAME));
            System.out.println((String)current.get(COLOR));
            listPlayers.add(new LocalPlayer((String) current.get(NAME), ColorFactory.getColor((String)current.get(COLOR))));
        }

        return listPlayers;
    }

    // Get one local player with his name
    public static LocalPlayer getById(String name) {
        for (LocalPlayer p : getAll()) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Function to create player
     *
     * @return 1 if player created  / 2 if the players is already existing / 3 if error
     */
    public static int createPlayer(LocalPlayer p) {

        // Copy JSON file
        ModifyFiles.saveJSONFile(DATA_JSON_FILE);

        // Var that will be return
        int ret = 1;

        // Test if the player already exist
        if (getById(p.getName()) != null){
            ret = 2;
        } else {
            JSONArray players = (JSONArray) getDataFile().get(DEFAULT_NODE);
            JSONObject newPlayer = new JSONObject();// new player
            newPlayer.put(NAME, p.getName());
            newPlayer.put(COLOR, ColorFactory.getStringColor(p.getColor()));
            players.add(newPlayer);

            // Create a copy
            ModifyFiles.saveJSONFile(DATA_JSON_FILE);

            JSONObject dataJSON = getDataFile();
            dataJSON.put(DEFAULT_NODE, players);

            ModifyFiles.write(DATA_JSON_FILE, dataJSON);
        }

        // Si L'ajout c'est bien passé on supprime la copie du fichier
        if (ret == 1 || ret == 2) {
            ModifyFiles.removeCopyJSONFile(DATA_JSON_FILE);
        } else if (ret == 3) { // On remet l'ancien fichier
            // Delete the origial path
            ModifyFiles.removeFile(DATA_JSON_FILE);
            // Put the copie on the default file
            ModifyFiles.reputOriginalJsonFile(DATA_JSON_FILE);
        }
        return ret;
    }

    public static int flushData (JSONObject o) {
        int ret = -1;
        try (FileWriter file = new FileWriter(DATA_JSON_FILE)) {

            file.write((o).toJSONString());
            file.flush();

        } catch (IOException io) {
            ret = 3;
        }
        return ret;
    }


}
