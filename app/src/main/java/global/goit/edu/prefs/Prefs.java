package global.goit.edu.prefs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Prefs {

    public static final String DB_URL = "dbUrl";
    public static final String TEST_DB_URL = "testDbUrl";
    public static final String DEFAULT_DB_FILE_PATH =
            "D:\\Java\\IDEProjects\\Developer\\DevHomeworkModule6\\app\\src\\main\\resources\\sql\\DbConfig.json";
    public static final String INIT_DB_FILE_PATH = "initDbFilePath";
    public static final String INSERT_INTO_BD_FILE_PATH = "insertIntoBdFilePath";
    public static final String INSERT_INTO_BD_WORKER_FILE_PATH = "insertIntoBdWorkerFilePath";
    public static final String INSERT_INTO_BD_CLIENT_FILE_PATH = "insertIntoBdClientFilePath";
    public static final String INSERT_INTO_BD_PROJECT_FILE_PATH = "insertIntoBdProjectFilePath";
    public static final String INSERT_INTO_BD_PROJECT_WORKER_FILE_PATH = "insertIntoBdProjectWorkerFilePath";
    public static final String QUERY_FIND_LONGEST_PROJECT_FILE_PATH = "findLongestProjectFilePath";
    public static final String QUERY_FIND_MAX_PROJECTS_CLIENT_FILE_PATH = "findMaxProjectsClientFilePath";
    public static final String QUERY_FIND_MAX_SALARY_WORKER_FILE_PATH = "findMaxSalaryWorkerFilePath";
    public static final String QUERY_FIND_YOUNGEST_ELDEST_WORKERS_FILE_PATH = "findYoungestEldestWorkersFilePath";
    public static final String QUERY_PRINT_PROJECT_PRICES_FILE_PATH = "printProjectPricesFilePath";
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
