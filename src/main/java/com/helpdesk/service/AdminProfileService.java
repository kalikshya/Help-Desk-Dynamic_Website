package com.helpdesk.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.helpdesk.config.DBConfig;
import com.helpdesk.model.UserModel;


public class AdminProfileService {

    private Connection dbConn;

    public AdminProfileService() {
        try {
            dbConn = DBConfig.getDbConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean updateAdminProfile(UserModel admin) {
        String sql = "UPDATE user SET full_name = ?, email = ?, username = ?, password = ? WHERE user_id = ?";

        try (PreparedStatement stmt = dbConn.prepareStatement(sql)) {
            stmt.setString(1, admin.getFull_name());
            stmt.setString(2, admin.getEmail());
            stmt.setString(3, admin.getUsername());
            stmt.setString(4, admin.getPassword()); // optional: hash password
            stmt.setInt(5, admin.getUser_id());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}