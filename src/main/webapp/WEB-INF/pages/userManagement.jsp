<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Management</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/userManagement.css">
</head>
<body>

<div class="dashboard-container">
    
    <!-- Sidebar -->
    <div class="sidebar">
        <ul>
            <li><a href="${pageContext.request.contextPath}/adminDashboard">Dashboard</a></li>
            <li><a href="${pageContext.request.contextPath}/manageProblems">Manage Problems</a></li>
            <li><a href="${pageContext.request.contextPath}/userManagement" class="active">User Management</a></li>
            <li><a href="${pageContext.request.contextPath}/viewFeedback">Feedbacks</a></li>
            <li><a href="${pageContext.request.contextPath}/adminProfile">Admin Profile</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
        </ul>
    </div>

    <!-- Main Content -->
    <div class="main-content">
        <h1>User Management</h1>
        
        <div class="top-bar">
             <form class="search-form" action="${pageContext.request.contextPath}/userManagement" method="get">
                <input type="text" name="keyword" placeholder="Search users..." value="${keyword != null ? keyword : ''}"/>
                <button type="submit">Search</button>
             </form>
             
            <button class="add-btn">Add User</button>
            <!-- Add User Form (Initially Hidden) -->
<div id="addUserForm" style="display: none; margin-top: 20px; background-color: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 4px 12px rgba(0,0,0,0.1);">
    <h3>Add New User</h3>
    <form action="#" method="post">
        <input type="text" name="fullname" placeholder="Full Name" required><br><br>
        <input type="text" name="username" placeholder="Username" required><br><br>
        <input type="email" name="email" placeholder="Email" required><br><br>
        <button type="submit" style="background-color:#0077B6; color:white; padding:10px 20px; border:none; border-radius:6px;">Submit</button>
    </form>
</div>
        </div>
        
        <table>
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>Full Name</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.user_id}</td>
            <td>${user.full_name}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.status}</td>
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

<script>
    document.querySelector(".add-btn").addEventListener("click", function () {
        const form = document.getElementById("addUserForm");
        form.style.display = form.style.display === "none" ? "block" : "none";
    });
</script>

</body>
</html>
