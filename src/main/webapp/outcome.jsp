<%--
  Created by IntelliJ IDEA.
  User: xavier
  Date: 7/20/23
  Time: 09:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <jsp:include page="partials/head.jsp">
    <jsp:param name="title" value="Guess Answer"/>
  </jsp:include>
</head>
<body>
  <header>
    <jsp:include page="partials/navbar.jsp"/>
  </header>
  <main>
    <h1>${outcome}</h1>
  </main>
</body>
</html>
