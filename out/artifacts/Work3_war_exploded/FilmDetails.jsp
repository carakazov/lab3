<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 26.12.2020
  Time: 3:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Films details</title>
    <link rel="stylesheet" href="css/bootstrap.css" >
</head>
<body>
<h1 class="h1">Film information</h1>
    <ul class="list-group">
        <li class="list-group-item">
            <label>Title: </label>
            <c:out value="${film.title}"/>
        </li>
        <li class="list-group-item">
            <label>Rating: </label>
            <c:out value="${film.rating}"/>
        </li>
        <li class="list-group-item">
            <label>Director's name:</label>
            <c:out value="${film.director.name}"/>
        </li>
        <li class="list-group-item">
            <label>Director's surname:</label>
            <c:out value="${film.director.surname}"/>
        </li>
    </ul>
    <form method="post" action="details">
        <input type="hidden" name="id" value="${film.id}">
        <input type="submit" value="Delete">
    </form>
</body>
</html>
