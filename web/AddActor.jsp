<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 26.12.2020
  Time: 5:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add actor</title>
    <link rel="stylesheet" href="css/bootstrap.css" >
</head>
<body>
<h1 class="h1">Add new film</h1>
<form method="post" action="addActor">
    <label>
        <label>Input name</label>
        <input type="text" class="form-control" name="name"/>
    </label>
    <label>
        <label>Input surname</label>
        <input type="text" class="form-control" name="surname">
    </label>
    <p>
        <label>
            <input type="submit" value="Add">
        </label>
    </p>
</form>
</body>
</html>
