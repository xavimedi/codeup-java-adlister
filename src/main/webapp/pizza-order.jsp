<%--
  Created by IntelliJ IDEA.
  User: xavier
  Date: 7/19/23
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Pizza Order"/>
    </jsp:include>
</head>
<body>
<header>
    <jsp:include page="partials/navbar.jsp"/>
</header>
<h1>Pizza Order Form</h1>

<form action="/pizza-order" method="post">
    <label for="crustType">Crust Type:</label>
    <select id="crustType" name="crust" required>
        <option value="Thin">Thin</option>
        <option value="Thick">Thick</option>
        <option value="Regular">Regular</option>
    </select><br>

    <label for="sauceType">Sauce Type:</label>
    <select id="sauceType" name="sauce" required>
        <option value="Tomato">Tomato</option>
        <option value="Pesto">Pesto</option>
        <option value="Barbecue">Barbecue</option>
    </select><br>

    <label for="size">Size:</label>
    <select id="size" name="size" required>
        <option value="Small">Small</option>
        <option value="Medium">Medium</option>
        <option value="Large">Large</option>
    </select><br>

    <label>Toppings:</label><br>
    <input type="checkbox" name="toppings[]" value="Pepperoni">Pepperoni<br>
    <input type="checkbox" name="toppings[]" value="Mushrooms">Mushrooms<br>
    <input type="checkbox" name="toppings[]" value="Onions">Onions<br>
    <input type="checkbox" name="toppings[]" value="Peppers">Peppers<br>

    <label for="deliveryAddress">Delivery Address:</label>
    <input type="text" id="deliveryAddress" name="address" required><br>

    <input type="submit" value="Place Order">
</form>
</body>
</html>


