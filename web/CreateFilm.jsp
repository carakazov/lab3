<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 26.12.2020
  Time: 3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create film</title>
    <link rel="stylesheet" href="css/bootstrap.css" >
</head>
<body>
<h1 class="h1">Add new film</h1>
    <form method="post" action="addFilm">
        <label>
            <label>Input title</label>
            <input type="text" class="form-control" name="title"/>
        </label>
        <label>
            <label>Input rating</label>
            <input type="text" class="form-control" name="rating">
        </label>
        <label>
             <label>Input director's ID</label>
            <input type="text" class="form-control" name="directorId">
        </label>
        <p>
            <label>
                <input type="submit" value="Add">
            </label>
        </p>
    </form>
</body>
</html>
