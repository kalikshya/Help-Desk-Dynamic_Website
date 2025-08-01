<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminDashboard.css">
</head>
<body>
<div class="dashboard-container">
    <!-- Sidebar -->
    <div class="sidebar">
        <h2>Admin Dashboard</h2>
        <ul>
            <li><a href="${pageContext.request.contextPath}/manageProblems">Manage Problems</a></li>
            <li><a href="${pageContext.request.contextPath}/userManagement">User Management</a></li>
            <li><a href="${pageContext.request.contextPath}/viewFeedback">Feedbacks</a></li>
            <li><a href="${pageContext.request.contextPath}/adminProfile">Admin Profile</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
        </ul>
    </div>

    <!-- Main Content -->
    <div class="main-content">
        <h2>Welcome, Admin! Citizen Problem Management Dashboard</h2>


        <!-- Cards Section -->
        <div class="cards">
            <div class="card">
                <h3>Total Problems</h3>
                <p>${totalProblems}</p>
            </div>
            <div class="card">
                <h3>Resolved</h3>
                <p>${resolvedProblems}</p>
            </div>
            <div class="card">
                <h3>Pending</h3>
                <p>${pendingProblems}</p>
            </div>
        </div>


       
        <!-- Table Section -->
        <div class="table-section">
            <h3>Recent Reports Overview</h3>
            <table>
                <thead>
                    <tr>
                        <th>Problem ID</th>
                        <th>Status</th>
                        <th>Date</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="report" items="${recentReports}">
                        <tr>
                            <td>${report.problem_id}</td>
                            <td>${report.status}</td>
                            <td>${report.date}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<div class="footer">
        &copy; 2025 HelpDesk | Empowering Citizens
    </div>

</body>
</html>