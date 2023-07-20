<%--
  Created by IntelliJ IDEA.
  User: xavier
  Date: 7/20/23
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quote Example</title>
</head>
<body>
<h1>My favorite quote author is <c:out value="${quote.author}" /> and my favorite quote of his is:
    <c:out value="${quote.quote}" /></h1>
</body>
</html>
