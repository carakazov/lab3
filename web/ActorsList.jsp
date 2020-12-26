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
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.css" >
</head>
<body>
<h1>All actors</h1>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Name</th>
        <th scope="col">Surname</th>
        <th scope="col">Details</th>
    </tr>
    </thead>
    <c:forEach items="${list}" var="actor">
        <tr>
            <td>${actor.name}</td>
            <td>${actor.surname}</td>
            <td><a href="actorDetails?id=${actor.id}">Show details</a></td>
        </tr>
    </c:forEach>
</table>
<a href="AddActor.jsp">Add actor</a>
</body>
</html>
