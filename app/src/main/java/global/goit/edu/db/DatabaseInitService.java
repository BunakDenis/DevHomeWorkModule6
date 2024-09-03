package global.goit.edu.db;

import global.goit.edu.prefs.Prefs;
import org.flywaydb.core.Flyway;

public class DatabaseInitService {
    public static void main(String[] args) {
        Flyway flyway = Flyway
                .configure()
                .dataSource(
                        new Prefs().getPrefValue(Prefs.TEST_DB_URL),
                        null,
                        null
                )
                .load();

        flyway.migrate();
    }
}