<%--
  Created by IntelliJ IDEA.
  User: xavier
  Date: 7/20/23
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Album Example</title>
</head>
<body>
<h1>My favorite album is <c:out value="${album.name}"/> by <c:out value="${album.artist}"/> </h1>
</body>
</html>
