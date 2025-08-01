<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelpDesk</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">

</head>
<body>
<div class="navbar">
    <span class="logo-text" onclick="location.href='${pageContext.request.contextPath}/home'">HelpDesk</span>
    <div class="nav-links">
        <a href="${pageContext.request.contextPath}/home">Home</a>
           <a href="${pageContext.request.contextPath}/aboutUs">About Us</a>
            <a href="${pageContext.request.contextPath}/contact">Contact</a>
            <a href="${pageContext.request.contextPath}/login">Login</a>
    </div>
</div>


    <div class="page-content">

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:if test="${param.success == '1'}">
        <p class="success-msg">✅ Registration successful! Please login.</p>
    </c:if>
    
    
    <div class="login-container">
    
     <!-- Left -->
      <div class="login-form">
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<c:if test="${not empty error}">
    	<div style="color: red; text-align: center; margin-bottom: 15px;">
        	${error}
    	</div>
	</c:if>
      
      
            <h2>Login</h2>
            <form action= "${pageContext.request.contextPath}/login" method="post">
                <input type="email" placeholder="Email" name="email" required>
                <input type="password" placeholder="Password" name="password" required>
                <button type="submit">Login</button>
            </form>
            <p class="register-link">New User? <a href="${pageContext.request.contextPath}/register">Register</a></p>
        </div>
        
        <!-- Right -->
        <div class="login-welcome">
            <h2>Welcome Back!</h2>
            <p>Please login with your personal information.</p>
        </div>
        
    </div>
      
    </div>
 <!-- Footer -->
    <div class="footer">
        &copy; 2025 HelpDesk | Empowering Citizens
    </div>
</body>
</html>