package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DB {

    static Connection getConnection() throws SQLException {
        // Connection parameters
        String databaseName = "BabDB";
        String user = "postgres";
        String password = "password";

        String connectionString = "jdbc:postgresql://localhost:5432/" + databaseName;
        Connection conn = DriverManager.getConnection(connectionString, user, password);
        return conn;
    }
}