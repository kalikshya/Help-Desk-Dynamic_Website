package com.helpdesk.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBConfig handles database connection for the HelpDesk project.
 */
public class DBConfig {

    // Database connection details
    private static final String DB_NAME = "helpdesk";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";  // No password set

    /**
     * Establishes and returns a database connection.
     *
     * @return Connection object
     * @throws SQLException if a database access error occurs
     * @throws ClassNotFoundException if the JDBC driver is not found
     */
    
    public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Load JDBC driver
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    
}

