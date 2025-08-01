package com.helpdesk.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.helpdesk.config.DBConfig;
import com.helpdesk.model.ViewFeedbackModel;

public class ViewFeedbackService {

    private Connection dbConn;

    public ViewFeedbackService() {
        try {
            dbConn = DBConfig.getDbConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<ViewFeedbackModel> getAllFeedbacks() {
        List<ViewFeedbackModel> feedbackList = new ArrayList<>();
        String query = "SELECT f.feedback_id, f.user_id, u.email, p.title, f.f_date, f.comments " +
                       "FROM feedback f " +
                       "JOIN user u ON f.user_id = u.user_id " +
                       "JOIN problem p ON f.problem_id = p.problem_id";

        try (PreparedStatement stmt = dbConn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ViewFeedbackModel feedback = new ViewFeedbackModel(
                    rs.getInt("feedback_id"),
                    rs.getInt("user_id"),
                    rs.getString("email"),
                    rs.getString("title"),
                    rs.getDate("f_date").toLocalDate(),
                    rs.getString("comments")
                );
                feedbackList.add(feedback);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return feedbackList;
    }
}
