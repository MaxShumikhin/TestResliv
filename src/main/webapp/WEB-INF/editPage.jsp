<%--
  Created by IntelliJ IDEA.
  User: Maksim
  Date: 24.03.2020
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"\>
    <title>Edit</title>
    <style>
        .center {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="center">

    Отредактируйте информацию

    <form action="/edit" method="post">
        <input type="hidden" name="id" value="${geography.id}"><br><br>
        Город <input type="text" name="nameCity" value="${geography.nameCity}"
                     placeholder=${geography.nameCity}><br><br>
        Описание <input type="text" name="description" value="${geography.description}"
                        placeholder=${geography.description}><br><br>
        <input type="submit" value="Изменить">
    </form>

    <form action="/all">
        <input type="submit" value="Отмена">
    </form>
</div>
</body>
</html>
