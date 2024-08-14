package global.goit.edu.db;

import global.goit.edu.prefs.Prefs;

import java.util.ArrayList;
import java.util.List;

public class DatabasePopulateService {
    private final Database db;

    public DatabasePopulateService(Database db) {
        this.db = db;
    }

    public void insertInfoOfPopulate(String sql) {
        List<String> sqlExpressions = readSqlExpression(sql);

        for (String sqlExpression : sqlExpressions) {
            db.executeUpdate(sqlExpression);
        }
    }

    private List<String> readSqlExpression(String sql) {
        List<String> result = new ArrayList<>();
        String insert = "INSERT";

        for (String expression : sql.split(insert)) {
            if (!expression.isEmpty()) {
                result.add(insert + expression);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        String sql = new SqlFileReader()
                .read(new Prefs().getPrefValue(Prefs.INSERT_INTO_BD_FILE_PATH));

        new DatabasePopulateService(Database.getInstance())
                    .insertInfoOfPopulate(sql);

    }
}