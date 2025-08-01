package com.helpdesk.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.helpdesk.model.UserModel;
import com.helpdesk.service.DashboardService;
import com.helpdesk.util.SessionUtil;

/**
 * Servlet implementation class AdminDashboardController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/adminDashboard" })
public class AdminDashboardController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final DashboardService dashboardService = new DashboardService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserModel currentUser = SessionUtil.getLoggedInUser(request);

        // Access control
        if (currentUser == null || !"kcjohn@gmail.com".equalsIgnoreCase(currentUser.getEmail())) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // Get data from service
        int total = dashboardService.getTotalProblems();
        int resolved = dashboardService.getResolvedProblems();
        int pending = dashboardService.getPendingProblems();

        // Set attributes for JSP
        request.setAttribute("totalProblems", total);
        request.setAttribute("resolvedProblems", resolved);
        request.setAttribute("pendingProblems", pending);
        request.setAttribute("recentReports", dashboardService.getRecentReports());

        // Forward to JSP
        request.getRequestDispatcher("/WEB-INF/pages/adminDashboard.jsp").forward(request, response);
    }
}
