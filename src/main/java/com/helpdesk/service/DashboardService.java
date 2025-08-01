package com.helpdesk.service;

import java.sql.*;
import java.util.*;

import com.helpdesk.config.DBConfig;

public class DashboardService {

    private Connection dbConn;

    public DashboardService() {
        try {
            dbConn = DBConfig.getDbConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Get total number of problems
    public int getTotalProblems() {
        String query = "SELECT COUNT(*) FROM problem";
        try (PreparedStatement stmt = dbConn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Get resolved problems
    public int getResolvedProblems() {
        String query = "SELECT COUNT(*) FROM problem WHERE status = 'Resolved'";
        try (PreparedStatement stmt = dbConn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Get pending problems
    public int getPendingProblems() {
        String query = "SELECT COUNT(*) FROM problem WHERE status != 'Resolved'";
        try (PreparedStatement stmt = dbConn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Get recent 3 problems
    public List<Map<String, String>> getRecentReports() {
        List<Map<String, String>> reports = new ArrayList<>();
        String query = "SELECT problem_id, status, date FROM problem ORDER BY date DESC LIMIT 3";

        try (PreparedStatement stmt = dbConn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Map<String, String> report = new HashMap<>();
                report.put("problemId", String.valueOf(rs.getInt("problem_id")));
                report.put("status", rs.getString("status"));
                report.put("date", rs.getString("date"));
                reports.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reports;
    }
}
