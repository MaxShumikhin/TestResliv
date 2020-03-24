<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: BVK
  Date: 3/24/2020
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
    <style>
        .center{text-align:  center;}
    </style>
</head>
<body>
<div class="center">
    <h1><b>Добавте новый город и описание</b></h1><br>

<form:form method="post" action="registration" modelAttribute="newCity">
    <input     type="text" name="nameCity" placeholder="Город"><br>
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
