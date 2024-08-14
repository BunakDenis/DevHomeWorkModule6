package global.goit.edu.prefs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Prefs {

    public static final String DB_URL = "dbUrl";
    public static final String DEFAULT_DB_FILE_PATH = "./sql/DbConfig.json";
    public static final String INIT_DB_FILE_PATH = "initDbFilePath";
    public static final String INSERT_INTO_BD_FILE_PATH = "insertIntoBdFilePath";
    public static final String QUERY_FIND_LONGEST_PROJECT = "findLongestProject";
    private Map<String, Object> prefs = new HashMap<>();

    public Prefs() {
        this(DEFAULT_DB_FILE_PATH);
    }

    public Prefs(String fileName) {
        try {

            String json = Files.readString(Path.of(fileName));

            TypeToken<?> typeToken = TypeToken.getParameterized(
                    Map.class,
                    String.class,
                    Object.class
            );

            prefs = new Gson().fromJson(json, typeToken.getType());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getPrefValue(String key) {
        return getPref(key).toString();
    }

    private Object getPref(String key) {
        return prefs.get(key);
    }

}
