// Utility Layer:
// This class handles database connection logic.
// It provides a single place to manage DB credentials and connections.

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    // JDBC URL for PostgreSQL
    // Format: jdbc:postgresql://<host>:<port>/<database_name>
    private static final String URL = "jdbc:postgresql://localhost:5432/ride_booking";

    // PostgreSQL username
    private static final String USER = "enter your username";
    //PostgreSQL password
    private static final String PASSWORD = "enter your password";

    public static Connection getConnection() {
        try {
            // DriverManager is used to create a connection with the database
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/ride_booking","enter your username","enter your password");
        } catch (Exception e) {
            // DriverManager is used to create a connection with the database
            System.out.println("Database connection failed!");
            e.printStackTrace();
            return null;
        }
    }
}
