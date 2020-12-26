<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 26.12.2020
  Time: 1:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Films list</title>
    <link rel="stylesheet" href="css/bootstrap.css" >
</head>
<body>
    <h1>All films</h1>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Title</th>
            <th scope="col">Rating</th>
            <th scope="col">Details</th>
        </tr>
        </thead>
        <c:forEach items="${list}" var="film">
            <tr>
                <td>${film.title}</td>
                <td>${film.rating}</td>
                <td><a href="details?id=${film.id}">Show details</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="CreateFilm.jsp">Add film</a>
</body>
</html>
