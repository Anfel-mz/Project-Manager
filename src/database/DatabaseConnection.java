package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://sql11.freesqldatabase.com:3306/";
    private static final String USERNAME = "sql11666752";
    private static final String PASSWORD = "fzJI8CZXLT";
    private static final String DATABASE_NAME = "sql11666752";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL + DATABASE_NAME, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    
}
