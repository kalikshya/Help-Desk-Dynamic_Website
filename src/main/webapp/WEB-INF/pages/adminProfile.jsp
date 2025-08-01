<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Profile</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminProfile.css">
</head>
<body>
<div class="dashboard-container">
    <!-- Sidebar -->
    <div class="sidebar">
        <ul>
            <li><a href="${pageContext.request.contextPath}/adminDashboard">Dashboard</a></li>
            <li><a href="${pageContext.request.contextPath}/manageProblems">Manage Problems</a></li>
            <li><a href="${pageContext.request.contextPath}/userManagement">User Management</a></li>
            <li><a href="${pageContext.request.contextPath}/viewFeedback">Feedbacks</a></li>
            <li><a href="${pageContext.request.contextPath}/adminProfile" class="active">Admin Profile</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
        </ul>
    </div>

    <!-- Main Content -->
    <div class="content">
        <h1>Admin Profile</h1>
        
        <c:if test="${not empty message}">
            <p class="success">${message}</p>
        </c:if>

        <c:if test="${not empty error}">
            <p class="error">${error}</p>
        </c:if>

        <div class="profile-box">
            <div class="profile-info">
                <p><strong>Admin ID:</strong>101</p>
                <p><strong>Name:</strong>John Kc</p>
                <p><strong>Email:</strong> kcjohn@gmail.com</p>
                <p><strong>Username:</strong>john</p>
                <p><strong>Role:</strong> Admin</p>
            </div>

            <div class="edit-section">
                <h3>Update Info</h3>
                <form action="${pageContext.request.contextPath}/adminProfile" method="post">
                    <input type="text" name="fullname" placeholder="Full Name">
                    <input type="email" name="email" placeholder="Email">
                    <input type="text" name="username" placeholder="Username">
                    <input type="password" name="password" placeholder="New Password">
                    <button type="submit">Update Admin Profile</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Footer -->
<div class="footer">
    &copy; 2025 HelpDesk | Empowering Citizens
</div>

</body>
</html>