<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Us</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/contact.css">
 
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

    <!-- Contact Form -->
    <div class="contact-container">
        <h2>Contact Us</h2>
        <form action="#" method="post">
            <label for="name">Name</label>
            <input type="text" id="name" placeholder="Your Name" required>

            <label for="email">Email</label>
            <input type="email" id="email" placeholder="Your Email" required>

            <label for="message">Message</label>
            <textarea id="message" placeholder="Your Message" rows="4" required></textarea>

            <button type="submit">Submit</button>
        </form>
    </div>

    <!-- Footer -->
   <div class="footer">
        &copy; 2025 HelpDesk | Empowering Citizens
    </div>
</body>
</html>