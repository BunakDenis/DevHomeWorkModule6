package global.goit.edu.db;

import global.goit.edu.prefs.Prefs;

public class DatabaseInitService {
    public static void main(String[] args) {
        String sql = new SqlFileReader()
                .read(new Prefs().getPrefValue(Prefs.INIT_DB_FILE_PATH));
        Database.getInstance().executeUpdate(sql);
    }
}