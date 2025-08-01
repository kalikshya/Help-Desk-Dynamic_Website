<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/myProfile.css">
</head>
<body>
<div class="dashboard-container">
    <!-- Sidebar -->
    <div class="sidebar">
        <h2><a href="${pageContext.request.contextPath}/userDashboard" class="dashboard-link">User Panel</a></h2>
        <ul>
            <li><a href="${pageContext.request.contextPath}/reportProblem">Report Problem</a></li>
            <li><a href="${pageContext.request.contextPath}/trackStatus">Track Status</a></li>
            <li><a href="${pageContext.request.contextPath}/submitFeedback">Submit Feedback</a></li>
            <li><a href="${pageContext.request.contextPath}/myProfile" class="active">My Profile</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
        </ul>
    </div>

    <!-- Main Content -->
    <div class="content">
        <div class="profile-info">
            <h2>My Profile</h2>
            <p><strong>Full Name:</strong> [User Name]</p>
            <p><strong>Username:</strong> [Username]</p>
            <p><strong>Email:</strong> [Email]</p>
            <button class="update-btn">Update Profile</button>
        </div>
    </div>
</div>

<!-- Footer -->
<div class="footer">
    &copy; 2025 HelpDesk | Empowering Citizens
</div>

</body>
</html>