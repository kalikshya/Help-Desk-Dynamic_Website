package com.helpdesk.service;

import com.helpdesk.config.DBConfig;
import com.helpdesk.model.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserManagementService {
    private Connection dbConn;

    public UserManagementService() {
        try {
            dbConn = DBConfig.getDbConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<UserModel> getAllUsers() {
        List<UserModel> users = new ArrayList<>();
        String sql = "SELECT * FROM user";

        try (PreparedStatement stmt = dbConn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                users.add(mapResultSetToUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
    
    
 // Search users by full_name, username, or email
    public List<UserModel> searchUsers(String keyword) {
        List<UserModel> users = new ArrayList<>();
        String sql = "SELECT * FROM user WHERE full_name LIKE ? OR username LIKE ? OR email LIKE ?";

        try (PreparedStatement stmt = dbConn.prepareStatement(sql)) {
            String searchKeyword = "%" + keyword + "%";
            stmt.setString(1, searchKeyword);
            stmt.setString(2, searchKeyword);
            stmt.setString(3, searchKeyword);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                users.add(mapResultSetToUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
    
    // Utility method to convert ResultSet to UserModel
    private UserModel mapResultSetToUser(ResultSet rs) throws SQLException {
        return new UserModel(
            rs.getInt("user_id"),
            rs.getString("full_name"),
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("password"),
            rs.getString("contact"),
            rs.getString("address"),
            rs.getString("status"),
            rs.getString("role")
        );
    }
}
