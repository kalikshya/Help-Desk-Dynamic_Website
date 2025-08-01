<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Report a Problem</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reportProblem.css">
</head>
<body>
<div class="dashboard-container">
    <!-- Sidebar -->
    <div class="sidebar">
        <h2><a href="${pageContext.request.contextPath}/userDashboard" class="dashboard-link">User Panel</a></h2>
        <ul>
            <li><a href="${pageContext.request.contextPath}/reportProblem" class="active">Report Problem</a></li>
            <li><a href="${pageContext.request.contextPath}/trackStatus">Track Status</a></li>
            <li><a href="${pageContext.request.contextPath}/submitFeedback">Submit Feedback</a></li>
            <li><a href="${pageContext.request.contextPath}/updateProfile">Update Profile</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
        </ul>
    </div>

    <!-- Main Content -->
    <div class="main-content">
        <h1>Report a Community Problem</h1>

        <form action="#" method="post" enctype="multipart/form-data" class="report-form">
            <label for="title">Problem Title:</label>
            <input type="text" id="title" name="title" required>

            <label for="description">Description:</label>
            <textarea id="description" name="description" rows="4" required></textarea>

            <label for="location">Location:</label>
            <input type="text" id="location" name="location" required>

            <label for="category">Category:</label>
            <select id="category" name="category">
                <option value="Garbage">Garbage</option>
                <option value="Water Supply">Water Supply</option>
                <option value="Electricity">Electricity</option>
                <option value="Road Damage">Road Damage</option>
                <option value="Others">Others</option>
            </select>

            <label for="date">Date Reported:</label>
            <input type="date" id="date" name="date" required>

            <label for="image">Upload Image (optional):</label>
            <input type="file" id="image" name="image">

            <button type="submit">Submit Problem</button>
        </form>
    </div>
</div>

<div class="footer">
    &copy; 2025 HelpDesk | Empowering Citizens
</div>
</body>
</html>