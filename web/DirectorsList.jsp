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
    <title>Directors list</title>
    <link rel="stylesheet" href="css/bootstrap.css" >
</head>
<body>
<h1>All films</h1>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Name</th>
        <th scope="col">Surname</th>
    </tr>
    </thead>
    <c:forEach items="${list}" var="director">
        <tr>
            <td>${director.name}</td>
            <td>${director.surname}</td>
            <td><a href="directorDetails?id=${director.id}">Show details</a></td>
        </tr>
    </c:forEach>
</table>
<a href="AddDirector.jsp">Add director</a>
</body>
</html>
