package com.helpdesk.service;

import com.helpdesk.config.DBConfig;
import com.helpdesk.model.ProblemModel;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProblemService {

    private Connection conn;

    public ProblemService() {
        try {
            conn = DBConfig.getDbConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ProblemModel> getAllProblems() {
        List<ProblemModel> list = new ArrayList<>();
        String sql = "SELECT problem_id, title, date, status FROM problem";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ProblemModel problem = new ProblemModel();
                problem.setProblem_id(rs.getInt("problem_id"));
                problem.setTitle(rs.getString("title"));
                problem.setDate(rs.getDate("date").toLocalDate());
                problem.setStatus(rs.getString("status"));

                list.add(problem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean addProblem(ProblemModel problem) {
        String sql = "INSERT INTO problem (title, category, date, status, dept_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, problem.getTitle());
            stmt.setString(2, problem.getCategory());
            stmt.setDate(3, Date.valueOf(problem.getDate()));
            stmt.setString(4, problem.getStatus());
            stmt.setInt(5, problem.getDept_id());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
}
    
}
   