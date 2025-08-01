<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Reported Problems</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/manageProblems.css">
</head>
<body>

<div class="dashboard-container">
    <!-- Sidebar -->
    <div class="sidebar">
        <ul>
            <li><a href="${pageContext.request.contextPath}/adminDashboard">Dashboard</a></li>
            <li><a href="${pageContext.request.contextPath}/manageProblems" class="active">Manage Problems</a></li>
            <li><a href="${pageContext.request.contextPath}/userManagement">User Management</a></li>
            <li><a href="${pageContext.request.contextPath}/viewFeedback">Feedbacks</a></li>
            <li><a href="${pageContext.request.contextPath}/adminProfile">Admin Profile</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
        </ul>
    </div>

    <!-- Main Content -->
    <div class="main-content">
        <h2>Manage Reported Problems</h2>

        <div class="top-bar">
            <a href="${pageContext.request.contextPath}/addProblem"><button class="add-btn">Add Problem</button></a>
        </div>

        <table>
            <thead>
                <tr>
                    <th>Problem ID</th>
                    <th>Title</th>
                    <th>Date </th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="problem" items="${problems}">
        <tr>
            <td>${problem.problem_id}</td>
            <td>${problem.title}</td>
            <td>${problem.date}</td>
            <td>${problem.status}</td>
            <td>
                <button class="update-btn">Update</button>
                <button class="delete-btn">Delete</button>
            </td>
        </tr>
    </c:forEach>
           </tbody>
            
        </table>

        <div class="footer">
            &copy; 2025 HelpDesk | Empowering Citizens
        </div>
    </div>
</div>

</body>
</html>