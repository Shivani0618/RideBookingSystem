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
    private static final String USER = "shivani";
    //PostgreSQL password
    private static final String PASSWORD = "shi8559#";

    public static Connection getConnection() {
        try {
            // DriverManager is used to create a connection with the database
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/ride_booking","shivani","shi8559#");
        } catch (Exception e) {
            // DriverManager is used to create a connection with the database
            System.out.println("Database connection failed!");
            e.printStackTrace();
            return null;
        }
    }
}
