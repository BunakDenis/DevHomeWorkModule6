package global.goit.edu.db;

import global.goit.edu.prefs.Prefs;

import java.sql.*;

public class Database {

    private static final Database INSTANCE = new Database();
    private Connection connection;

    private Database() {
        try {
            connection = DriverManager.getConnection(
                    new Prefs()
                            .getPrefValue(Prefs.TEST_DB_URL));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public int executeUpdate(String sql) {
        try {
            Statement st = connection.createStatement();
            return st.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public ResultSet executeQuery(String sql) {
        try {
            Statement st = connection.createStatement();
            return st.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void close() {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
