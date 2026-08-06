package com.clinic;

import com.clinic.config.HikariConnectionPool;
import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        try (Connection conn = HikariConnectionPool.getConnection()) {
            System.out.println("Connected successfully via HikariCP!");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        } finally {
            HikariConnectionPool.shutdown();
        }
    }
}