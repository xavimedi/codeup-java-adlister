<%--
  Created by IntelliJ IDEA.
  User: xavier
  Date: 7/20/23
  Time: 08:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <jsp:include page="partials/head.jsp">
    <jsp:param name="title" value="Guessing Game" />
  </jsp:include>
</head>
<body>
<header>
  <jsp:include page="partials/navbar.jsp" />
</header>
<main>
  <form action="/guess" method="post">
    <h3>Guess a number between 1 and 3!</h3>
    <label for="guess">Guess:</label>
    <select name="guess" id="guess" required>
      <option value="1">1</option>
      <option value="2">2</option>
      <option value="3">3</option>
    </select>
    <hr>
    <input type="submit" value="Submit">
  </form>
</main>
</body>
</html>


