<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Problem</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/addProblem.css">
</head>
<body>
<div class="form-container">
    <h2>Add New Problem</h2>
    <form action="${pageContext.request.contextPath}/addProblem" method="post">
        <label>Title:</label>
        <input type="text" name="title" required>

        <label>Category:</label>
        <input type="xategory" name="category" required>

        <label>Date Reported:</label>
        <input type="date" name="date" required>

        <label>Status:</label>
        <select name="status">
            <option>Pending</option>
            <option>In Progress</option>
            <option>Resolved</option>
        </select>

        <button type="submit">Submit Problem</button>
    </form>
</div>
</body>
</html>