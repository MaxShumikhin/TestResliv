<%--
  Created by IntelliJ IDEA.
  User: Maksim
  Date: 25.03.2020
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" \>
    <title>Add</title>
    <style>
        .center {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="center">
    <h1><b>Добавте нового пользователя</b></h1><br>

    <form:form method="post" action="registration" modelAttribute="newCity">
        <input type="text" name="nameCity" placeholder="City"><br>
        <textarea name="description" cols="255" rows="5"></textarea>
        <p>
            <button type="submit">Добавить</button>
        </p>
        <p>
            <button type="reset">Очистить</button>
        </p>
    </form:form>
    <form action="/all">
        <input type="submit" value="Назад">
    </form>

</div>
</body>
</html>
