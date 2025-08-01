<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/aboutUs.css">
  
  
<title>About Us </title>
</head>
<body>
<!-- Navbar -->
    <div class="navbar">
        <span class="logo-text" onclick="location.href='${pageContext.request.contextPath}/home'">HelpDesk</span>
        <div class="nav-links">
             <a href="${pageContext.request.contextPath}/home">Home</a>
           <a href="${pageContext.request.contextPath}/aboutUs">About Us</a>
            <a href="${pageContext.request.contextPath}/contact">Contact</a>
            <a href="${pageContext.request.contextPath}/login">Login</a>
        </div>
    </div>

    <!-- About Us Content -->
    <div class="about-box">
        <h2>About Us</h2>
        <p>
            We are established to empower citizens to raise their concerns and contribute to building a better community.
            Our mission is to create a platform where individuals can easily report issues, track progress,
            and actively participate in improving public services.
        </p>

        <h3>Vision</h3>
        <p>
            To build cleaner, more responsive cities while bridging the gap between citizens and authorities
            by providing a user-friendly system.
        </p>
        <p>
            By fostering collaboration and accountability, we aim to ensure that every voice is heard,
            and every problem is addressed. Together, we can make our communities thrive.
        </p>
    </div>

    <!-- Footer -->
    <div class="footer">
        &copy; 2025 HelpDesk | Empowering Citizens
    </div>
</body>
</html>