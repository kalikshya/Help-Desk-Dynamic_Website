<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feedbacks</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewFeedback.css">
</head>
<body>
<div class="dashboard-container">

    <!-- Sidebar -->
    <div class="sidebar">
        <ul>
           <li><a href="${pageContext.request.contextPath}/adminDashboard">Dashboard</a></li>
            <li><a href="${pageContext.request.contextPath}/manageProblems">Manage Problems</a></li>
            <li><a href="${pageContext.request.contextPath}/userManagement">User Management</a></li>
            <li><a href="${pageContext.request.contextPath}/viewFeedback" class="active">Feedbacks</a></li>
            <li><a href="${pageContext.request.contextPath}/adminProfile">Admin Profile</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
        </ul>
    </div>

    <!-- Main Content -->
    <div class="main-content">
        <h2>Citizen Feedbacks</h2>
        <table>
            <thead>
                <tr>
                    <th>Feedback ID</th>
                    <th>User ID</th>
                    <th>Email</th>
                    <th>Problem Title</th>
                    <th>Date Submitted</th>
                    <th>Comments</th>
                </tr>
            </thead>
             <tbody>
              <c:forEach var="feedback" items="${feedbackList}">
  
                  <tr>
                   <td>${feedback.feedback_id}</td>
                   <td>${feedback.user_id}</td>
                   <td>${feedback.email}</td>
                   <td>${feedback.problem_title}</td>
                   <td>${feedback.f_date}</td>
                   <td>${feedback.comments}</td>
                </tr>
             </c:forEach>
            </tbody>

        </table>
    </div>
</div>

<!-- Footer -->
<div class="footer">
    &copy; 2025 HelpDesk | Empowering Citizens
</div>

</body>
</html>