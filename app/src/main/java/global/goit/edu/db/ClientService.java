package global.goit.edu.db;

import global.goit.edu.prefs.Prefs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientService {

    private PreparedStatement insertIntoClientStatement;
    private PreparedStatement selectClientByNameStatement;
    private PreparedStatement selectClientByIdStatement;
    private PreparedStatement updateClientNameByIdStatement;
    private PreparedStatement deleteClientByIdStatement;
    private PreparedStatement selectAllClientsStatement;

    public ClientService(Database db) {
        Connection conn = db.getConnection();

        try {

            insertIntoClientStatement = conn.prepareStatement(new SqlFileReader().read(
                    new Prefs().getPrefValue(Prefs.INSERT_INTO_BD_CLIENT_FILE_PATH))
            );

            selectClientByNameStatement = conn.prepareStatement(new SqlFileReader().read(
                    new Prefs().getPrefValue(Prefs.SELECT_FROM_BD_CLIENT_BY_NAME_FILE_PATH)
            ));

            selectClientByIdStatement = conn.prepareStatement(new SqlFileReader().read(
                    new Prefs().getPrefValue(Prefs.SELECT_FROM_BD_CLIENT_BY_ID_FILE_PATH)
            ));

            updateClientNameByIdStatement = conn.prepareStatement(new SqlFileReader().read(
                    new Prefs().getPrefValue(Prefs.UPDATE_CLIENT_NAME_FROM_BD_BY_ID_FILE_PATH)
            ));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long create(String name) {

        if (name.length() >= 2 & name.length() <= 1000) {

            try {

                insertIntoClientStatement.setString(1, name);
                insertIntoClientStatement.executeUpdate();

                return getIdByName(name);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public long getIdByName(String name) {

        try {

            selectClientByNameStatement.setString(1, name);
            ResultSet rs = selectClientByNameStatement.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public String getById(long id) {

        try {

            selectClientByIdStatement.setLong(1, id);
            ResultSet rs = selectClientByIdStatement.executeQuery();

            if (rs.next()) {
                return rs.getString("name");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "-1";
    }

    public void setName (long id, String name) {

        try {
            updateClientNameByIdStatement.setString(1, name);
            updateClientNameByIdStatement.setInt(2, (int) id);
            updateClientNameByIdStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}