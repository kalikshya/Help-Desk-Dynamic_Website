package com.helpdesk.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.helpdesk.config.DBConfig;
import com.helpdesk.model.UserModel;

public class RegisterService {

	
    private Connection dbConn;

    public RegisterService() {
    	try {
            this.dbConn = DBConfig.getDbConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean registerUser(UserModel user) {
    	if (dbConn == null) {
            System.out.println("Database connection failed.");
            return false;
        }
    	
    	
        String insertQuery = "INSERT INTO user (full_name, email, password, status, role) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = dbConn.prepareStatement(insertQuery)) {
            stmt.setString(1, user.getFull_name());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getStatus());  // Default: "active"
            stmt.setString(5, user.getRole());    // Default: "user"
            
            int rows = stmt.executeUpdate();
            return rows > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public boolean emailExists(String email) {
        String insertQuery = "SELECT email FROM user WHERE email = ?";
        try (PreparedStatement stmt = dbConn.prepareStatement(insertQuery)) {
            stmt.setString(1, email);
            return stmt.executeQuery().next(); // true if match found
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
