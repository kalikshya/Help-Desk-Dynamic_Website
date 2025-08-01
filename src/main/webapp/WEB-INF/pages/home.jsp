<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@600;700&display=swap" rel="stylesheet">

<meta charset="UTF-8">
<title>HelpDesk</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">

<script>
    function goHome() {
        window.location.href = "${pageContext.request.contextPath}/home";
    }
</script>


</head>

<body>
<div class="navbar">
            <div class="nav-left">
            <span class="logo-text" onclick="goHome()">HelpDesk</span>
        </div>
        <div class="nav-right">
            <a href="${pageContext.request.contextPath}/home">Home</a>
            <a href="${pageContext.request.contextPath}/aboutUs">About Us</a>
            <a href="${pageContext.request.contextPath}/contact">Contact</a>
            <a href="${pageContext.request.contextPath}/login">Login</a>
            
        </div>
    </div>

    <!-- Main Split Hero Section -->
    <div class="split-hero">
        <!-- Left Text -->
        <div class="hero-left slide-in-left">
            <h1>Welcome,<br>To the Citizen Problem Management System</h1>
            <p>
                This platform empowers citizens to report problems in their neighborhood easily.<br>
                Whether it’s a pothole, broken street light, or sanitation issue — your voice matters.<br>
                Track your complaint, receive updates, and help build a better community together.
            </p>
        </div>


        <!-- Right logo -->
        <div class="hero-right">
            <img class="hero-logo" src="${pageContext.request.contextPath}/resources/images/system/helpdesk img.png" alt="Community Logo">
            
        </div>
    </div>

    <!-- Footer -->
    <div class="footer">
        &copy; 2025 HelpDesk | Empowering Citizens
    </div>
</body>
</html>