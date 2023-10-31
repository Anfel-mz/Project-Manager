package database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;  

public class DatabaseTest {
    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();

        if (connection != null) {
            System.out.println("Database connection successful.");

            try {
                // Query to retrieve the database version
                String query = "SELECT @@version";
                Statement statement = connection.createStatement();  
                ResultSet resultSet = statement.executeQuery(query);  

                while (resultSet.next()) {
                    String version = resultSet.getString(1);
                    System.out.println("Database version: " + version);
                }

                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Additional testing or query execution can be performed here.
        } else {
            System.err.println("Database connection failed.");
        }
    }
}
