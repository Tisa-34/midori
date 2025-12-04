package Config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/realtime_db";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection connection = null;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    
}
