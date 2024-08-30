package global.goit.edu.db;

import global.goit.edu.enterprise.WorkerLevel;
import global.goit.edu.prefs.Prefs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class DatabaseInsertService {

    private final Connection conn;
    private PreparedStatement insertWorkerStatement;
    private PreparedStatement insertClientStatement;
    private PreparedStatement insertProjectStatement;
    private PreparedStatement insertProjectWorkerStatement;

    public DatabaseInsertService(Database db) {
        this.conn = db.getConnection();

        try {
            insertWorkerStatement = conn.prepareStatement(
                    new SqlFileReader().read(
                            new Prefs().getPrefValue(Prefs.INSERT_INTO_BD_WORKER_FILE_PATH)
                    )
            );

            insertClientStatement = conn.prepareStatement(
                    new SqlFileReader().read(
                            new Prefs().getPrefValue(Prefs.INSERT_INTO_BD_CLIENT_FILE_PATH)
                    )
            );

            insertProjectStatement = conn.prepareStatement(
                    new SqlFileReader().read(
                            new Prefs().getPrefValue(Prefs.INSERT_INTO_BD_PROJECT_FILE_PATH)
                    )
            );

            insertProjectWorkerStatement = conn.prepareStatement(
                    new SqlFileReader().read(
                            new Prefs().getPrefValue(Prefs.INSERT_INTO_BD_PROJECT_WORKER_FILE_PATH)
                    )
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean createWorker(String name, Date birthday, WorkerLevel level, int salary) {

        try {
            insertWorkerStatement.setString(1, name);
            insertWorkerStatement.setDate(2, birthday);
            insertWorkerStatement.setString(3, level.getLevel());
            insertWorkerStatement.setInt(4, salary);

            return (insertWorkerStatement.executeUpdate() == 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean createClient(String name) {

        try {

            insertClientStatement.setString(1, name);

            return (insertClientStatement.executeUpdate() == 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean createProject(int clientId, Date startDate, Date finishDate) {

        try {

            insertProjectStatement.setInt(1, clientId);
            insertProjectStatement.setDate(2, startDate);
            insertProjectStatement.setDate(3, finishDate);

            return (insertProjectStatement.executeUpdate() == 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean createProjectWorker(int projectId, int workerId) {

        try {

            insertProjectWorkerStatement.setInt(1, projectId);
            insertProjectWorkerStatement.setInt(2, workerId);

            return (insertProjectWorkerStatement.executeUpdate() == 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
