package com.clinic.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class HikariConnectionPool {

    private static final HikariDataSource dataSource;

    static {
        Properties props = new Properties();
        try (InputStream input = HikariConnectionPool.class
                .getClassLoader()
                .getResourceAsStream("db.properties")) {

            if (input == null) {
                throw new RuntimeException("db.properties not found on classpath");
            }
            props.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load db.properties", e);
        }

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(props.getProperty("db.url"));
        config.setUsername(props.getProperty("db.username"));
        config.setPassword(props.getProperty("db.password"));
        config.setMaximumPoolSize(
                Integer.parseInt(props.getProperty("db.pool.size", "10")));
        config.setConnectionTimeout(30000); // 30 sec
        config.setIdleTimeout(600000);      // 10 min

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void shutdown() {
        if (dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
        }
    }

    private HikariConnectionPool() {}
}