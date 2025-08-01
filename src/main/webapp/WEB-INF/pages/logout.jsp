<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout - HelpDesk</title>
<link rel="stylesheet" href="../css/logout.css">
</head>
<body>

<!-- Logout Confirmation Dialog -->
<div class="confirm-container" id="confirmBox">
    <div class="confirm-box">
        <h2>Are you sure you want to logout?</h2>
        <div class="btn-group">
            <button onclick="logout()">Yes, Logout</button>
            <button onclick="cancelLogout()">Cancel</button>
        </div>
    </div>
</div>

<!-- Logged Out Message -->
<div class="message-container" id="logoutMessage" style="display:none;">
    <div class="message-box">
        <img src="../images/logout-icon.png" alt="Logout Icon" class="logout-icon">
        <h2>You’ve been logged out</h2>
        <p>Thank you for using HelpDesk.</p>
        <a href="login.jsp" class="login-btn">Back to Login</a>
    </div>
</div>

<div class="footer">
    &copy; 2025 HelpDesk | Empowering Citizens
</div>

<script>
    function logout() {
        document.getElementById("confirmBox").style.display = "none";
        document.getElementById("logoutMessage").style.display = "flex";
    }

    function cancelLogout() {
        window.history.back();  // Go back to previous page
    }
</script>

</body>
</html>
