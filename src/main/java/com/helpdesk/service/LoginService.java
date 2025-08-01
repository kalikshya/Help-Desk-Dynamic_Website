package com.helpdesk.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.helpdesk.config.DBConfig;
import com.helpdesk.model.UserModel;
import com.helpdesk.util.PasswordUtil;

public class LoginService {

    private Connection dbConn;

    public LoginService() {
        try {
            dbConn = DBConfig.getDbConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public UserModel login(String email, String plainPassword) {
        if (dbConn == null) {
            return null;
        }

        String query = "SELECT * FROM user WHERE email = ? AND status = 'active'";

        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedHashedPassword = rs.getString("password");
                String inputHashedPassword = PasswordUtil.hashPassword(plainPassword);

                if (storedHashedPassword.equals(inputHashedPassword)) {
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

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
