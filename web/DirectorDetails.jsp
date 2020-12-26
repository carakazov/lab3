<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 26.12.2020
  Time: 4:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Director details</title>
    <link rel="stylesheet" href="css/bootstrap.css" >
</head>
<body>
<h1 class="h1">About director</h1>
<ul class="list-group">
    <li class="list-group-item">
        <label>Name: </label>
        <c:out value="${director.name}"/>
    </li>
    <li class="list-group-item">
        <label>Surname: </label>
        <c:out value="${director.surname}"/>
    </li>
    <li class="list-group-item">
            <c:forEach items="${director.films}" var="film">
                <p>
                    <label>Film title: </label>
                    <c:out value="${film.title}"/>
                </p>
            </c:forEach>
    </li>
</ul>
<form method="post" action="directorDetails">
    <input type="hidden" name="id" value="${director.id}">
    <input type="submit" value="Delete">
</form>
</body>
</html>
