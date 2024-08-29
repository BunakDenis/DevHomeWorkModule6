package global.goit.edu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DatabaseInsertService {

    private Connection conn;
    private PreparedStatement insertWorkerStatement;
    private PreparedStatement insertClientStatement;
    private PreparedStatement insertProjectStatement;
    private PreparedStatement insertProjectWorkerStatement;

    /*
      TODO 1. Написать sql запрос к каждому statemet
      TODO 2. Написать методы к каждому запросу
     */
    public DatabaseInsertService(Database db) {
        this.conn = db.getConnection();

        try {
            insertWorkerStatement = conn.prepareStatement(
                    "INSERT INTO WORKER (name, birthday, level, salary) VALUE (?, ?, ?, ?)"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
