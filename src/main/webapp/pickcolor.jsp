<%--
  Created by IntelliJ IDEA.
  User: xavier
  Date: 7/20/23
  Time: 09:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Color Picker"/>
    </jsp:include>
</head>
<body>
<header>
    <jsp:include page="partials/navbar.jsp"/>
</header>
<h1>Pick Your Favorite Color</h1>
<form action="viewcolor.jsp" method="post">
    <label for="colorInput">Favorite Color:</label>
    <input type="text" id="colorInput" name="color" required>
    <input type="submit" value="Submit">
</form>
</body>
</html>

