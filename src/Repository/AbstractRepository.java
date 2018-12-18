package Repository;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AbstractRepository {
    protected static JSONObject getFile(String path) {
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(new FileReader(path));
            return (JSONObject) object;
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("Change the path");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Unable to read " + path);
    }
}
