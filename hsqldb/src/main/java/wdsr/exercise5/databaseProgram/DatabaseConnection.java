package wdsr.exercise5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final Logger log = LoggerFactory.getLogger(DatabaseConnection.class);
    private static DatabaseConnection instance = null;
    private Connection connection;

    private DatabaseConnection() {
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection createConnection(String username, String password) {
        try {
            return DriverManager.getConnection("jdbc:hsqldb:hsql://127.0.0.1:9001/test-db", username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
