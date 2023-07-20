<%--
  Created by IntelliJ IDEA.
  User: xavier
  Date: 7/20/23
  Time: 09:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <jsp:include page="partials/head.jsp">
    <jsp:param name="title" value="Guess Answer"/>
  </jsp:include>
</head>
<body style="background-color: <%= request.getParameter("color") %>;">
<header>
  <jsp:include page="partials/navbar.jsp"/>
</header>
<h1>Your Favorite Color</h1>
<p>Your favorite color is: <%= request.getParameter("color") %></p>
</body>
</html>
