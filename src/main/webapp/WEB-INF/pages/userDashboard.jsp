<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User dashboard</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/userDashboard.css">
</head>
<body>
<div class="dashboard-container">
    <!-- Sidebar -->
    <div class="sidebar">
        <h2>User Panel</h2>
        <ul>
            <li><a href="${pageContext.request.contextPath}/reportProblem">Report Problem</a></li>
            <li><a href="${pageContext.request.contextPath}/trackStatus">Track Status</a></li>
            <li><a href="${pageContext.request.contextPath}/submitFeedback">Submit Feedback</a></li>
            <li><a href="${pageContext.request.contextPath}/myProfile">My Profile</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
        </ul>
    </div>

    <!-- Main Content -->
    <div class="main-content">
        <h1>Welcome, User!</h1>
        <p class="description">This is your personal dashboard to manage and track your reported issues.</p>

        <div class="cards">
            <div class="card">
                <h3>Total Problems</h3>
                <p>06</p>
            </div>
            <div class="card">
                <h3>Resolved</h3>
                <p>03</p>
            </div>
            <div class="card">
                <h3>Pending</h3>
                <p>03</p>
            </div>
        </div>


         
    </div>
</div>

<div class="footer">
    &copy; 2025 HelpDesk | Empowering Citizens
</div>

</body>
</html>