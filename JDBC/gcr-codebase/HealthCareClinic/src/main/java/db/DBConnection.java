package db;

import java.sql.*;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/clinic";
    private static final String USER = "root";
    private static final String PASSWORD = "[removed for privacy purpose]";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}