<%--
  Created by IntelliJ IDEA.
  User: xavier
  Date: 7/20/23
  Time: 09:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="partials/head.jsp">
    <jsp:param name="title" value="Welcome!" />
  </jsp:include>
  <header>
    <jsp:include page="partials/navbar.jsp"/>
  </header>
</head>
<body>
<c:if test="true">
  <h1>This is the homepage for the Java Adlister Server</h1>
</c:if>
<c:if test="false">
  <h1>Something went wrong!</h1>
</c:if>
</body>
</html>

