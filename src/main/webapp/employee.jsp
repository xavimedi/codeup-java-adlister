<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xavier
  Date: 7/20/23
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Example</title>
</head>
<body>
    <h1>Howdy, <c:out value="${employee.firstName}"/> </h1>
</body>
</html>
