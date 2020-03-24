<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
    <title>Add</title>
    <style>
        .center {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="center">
    <h1><b>Добавление нового города</b></h1><br>

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
        <input type="submit" value="Выход">
    </form>

</div>
</body>
</html>
