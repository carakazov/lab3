<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 26.12.2020
  Time: 5:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Actor details</title>
</head>
<body>
<h1 class="h1">About director</h1>
<ul class="list-group">
    <li class="list-group-item">
        <label>Name: </label>
        <c:out value="${actor.name}"/>
    </li>
    <li class="list-group-item">
        <label>Surname: </label>
        <c:out value="${actor.surname}"/>
    </li>
    <li class="list-group-item">
        <c:forEach items="${actor.films}" var="film">
            <p>
                <label>Film title: </label>
                <c:out value="${film.title}"/>
            </p>
        </c:forEach>
    </li>
</ul>
<form method="post" action="actorDetails">
    <input type="hidden" name="id" value="${actor.id}">
    <input type="submit" value="Delete">
</form>
<label>Add film to actor</label>
<form method="get" action="filmToActor">
    <input type="hidden" name="actorId" value="${actor.id}">
    <input type="text" name="filmId">
    <input type="submit" value="Add">
</form>
</body>
</html>
