<%--
  Created by IntelliJ IDEA.
  User: Maksim
  Date: 24.03.2020
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удалить</title>
    <style>
        .center {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="center">
    <h1><b> Вы действительно хотите удалить ${param.nameCity} ?</h1></b>

    <form action="/delete" method="post">
        <input type="hidden" name="id" value="${param.id}">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="Удалить">
    </form>
</div>
</body>
</html>
