<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- JSTL Taglib -->

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
</head>
<body>

<div class="main-wrapper">
    <div class="register-container">

        <!-- Left Form -->
        <div class="register-form">
            <h2>Register</h2>

            <!-- Error Message-->
            <c:if test="${not empty error}">
                <div style="color: red; text-align: center; margin-bottom: 10px;">
                    ${error}
                </div>
            </c:if>

            <!-- Form -->
            <form action="${pageContext.request.contextPath}/register" method="post">
            
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

			<c:if test="${not empty error}">
  			  <div style="color: red; margin-bottom: 15px;">${error}</div>
			</c:if>
            
                <input type="text" placeholder="Full Name" name="full_name" required>
                <input type="email" placeholder="Email" name="email" required>
                <input type="password" placeholder="Password" name="password" required>
                <input type="password" placeholder="Confirm Password" name="confirmPassword" required>
                <button type="submit">Register</button>
            </form>

            <p class="login-link">Already have an account? <a href="${pageContext.request.contextPath}/login">Login</a></p>
        </div>

        <!-- Right Welcome Message -->
        <div class="register-welcome">
            <h2>Hello, New User!</h2>
            <p>Create an account to start your journey with us.</p>
        </div>

    </div>
</div>

<!-- Footer -->
<div class="footer">
    &copy; 2025 HelpDesk | Empowering Citizens
</div>

</body>
</html>
