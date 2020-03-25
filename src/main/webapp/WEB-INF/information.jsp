<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"\>
    <title>Information</title>
    <style>
        table {
            margin: auto;
        }

        .center {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="center">
    <h1><b>Полная информация</b></h1><br>

    <table border="2">
        <tr>
            <th>Город</th>
            <th>Информация</th>
            <th>Действия</th>

        </tr>
        <c:forEach items="${geographyList}" var="geographyList">
            <tr>
                <td>${geographyList.nameCity}</td>
                <td>${geographyList.description}</td>
                <td>
                    <br>
                    <form action="edit/${geographyList.id}" method="get">
                        <input type="submit" value="Редактировать">
                    </form>
                    <br>
                    <br>
                    <form action="/delete" method="get">
                        <input type="hidden" name="id" value="${geographyList.id}">
                        <input type="hidden" name="nameCity" value="${geographyList.nameCity}">
                        <input type="submit" value="Удалить">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <p>
    <form action="/add" method="get">
        <input type="submit" value="Добавить новый город и описание"/>
    </form>
    </p>
</div>
</body>
</html>
