<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Submit Feedback</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/submitFeedback.css">
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
            <li><a href="${pageContext.request.contextPath}/myProfile">My Profile</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
        </ul>
    </div>

    <!-- Main Content -->
    <div class="content">
        <h2>Submit Feedback</h2>

        <form action="${pageContext.request.contextPath}/submitFeedback" method="post" class="feedback-form">
            <label for="name">Full Name:</label>
            <input type="text" name="name" id="name" required>

            <label for="email">Email:</label>
            <input type="email" name="email" id="email" required>

            <label for="feedback">Your Feedback:</label>
            <textarea name="feedback" id="feedback" rows="6" required></textarea>

            <button type="submit">Submit Feedback</button>
        </form>
    </div>
</div>

<!-- Footer -->
<div class="footer">
    &copy; 2025 HelpDesk | Empowering Citizens
</div>

</body>
</html>