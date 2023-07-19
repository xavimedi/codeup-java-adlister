<%--
  Created by IntelliJ IDEA.
  User: xavier
  Date: 7/19/23
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <div>
        <form action="/login.jsp" method="POST">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>

            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>

<%
    if(request.getMethod().equalsIgnoreCase("post")){
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if(username.equals("admin") && password.equals("password")){
			response.sendRedirect("/profile.jsp");
        }
    }
%>

