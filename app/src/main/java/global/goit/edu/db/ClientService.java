package global.goit.edu.db;

import global.goit.edu.enterprise.Client;
import global.goit.edu.prefs.Prefs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

            deleteClientByIdStatement = conn.prepareStatement(new SqlFileReader().read(
                    new Prefs().getPrefValue(Prefs.DELETE_CLIENT_FROM_BD_BY_ID_FILE_PATH)
            ));

            selectAllClientsStatement = conn.prepareStatement(new SqlFileReader().read(
                    new Prefs().getPrefValue(Prefs.SELECT_ALL_CLIENTS_FROM_BD_FILE_PATH)
            ));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long create(String name) {

        checkLengthName(name);

        try {
            insertIntoClientStatement.setString(1, name);
            insertIntoClientStatement.executeUpdate();

            return getIdByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public long getIdByName(String name) {

        checkLengthName(name);

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

        checkId(id);

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

    public void setName(long id, String name) {

        checkLengthName(name);

        try {
            updateClientNameByIdStatement.setString(1, name);
            updateClientNameByIdStatement.setInt(2, (int) id);
            updateClientNameByIdStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteById(long id) {

        checkId(id);

        try {

            deleteClientByIdStatement.setInt(1, (int) id);
            deleteClientByIdStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Client> listAll() {

        List<Client> result = new ArrayList<>();

        try {

            ResultSet rs = selectAllClientsStatement.executeQuery();

            while (rs.next()) {
                Client client = new Client();

                client.setId(rs.getLong("id"));
                client.setName(rs.getString("name"));

                result.add(client);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static void checkLengthName(String name) {
        if (!(name.length() >= 2)) {
            String messageForLengthNameOf2letters = "Length of user name must be longer then 2 letters";
            throw new IllegalArgumentException(messageForLengthNameOf2letters);
        }

        if (!(name.length() <= 1000)) {
            String messageForLengthNameLongerThen1000Letters =
                    "Length of user name must be shorter than 1000 letters";
            throw new IllegalArgumentException(messageForLengthNameLongerThen1000Letters);
        }
    }

    private static void checkId(long id) {

        if (id < 0) {
            String message = "Id must be more than 0";
            throw new IllegalArgumentException(message);
        }

    }

}