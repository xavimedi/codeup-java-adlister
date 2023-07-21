
<%--
  Created by IntelliJ IDEA.
  User: xavier
  Date: 7/21/23
  Time: 09:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Ads</title>
    <jsp:include page="../partials/head.jsp"></jsp:include>
  </head>
  <body>
    <jsp:include page="../partials/navbar.jsp"></jsp:include>

    <C:forEach var="ad" items="${ads}">
      <div class="product">
        <h1>${ad.title}</h1>
        <h3>${ad.description}</h3>
      </div>
    </C:forEach>
  </body>
</html>
