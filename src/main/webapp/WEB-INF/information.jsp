<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maksim
  Date: 23.03.2020
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Information</title>
    <style>
        .center{text-align:  center;}
    </style>
</head>
<body>
<div class="center">
    <h1><b>Полная информация</b></h1><br>

    <table border="2">
        <tr>
            <th>Id</th>
            <th>Город</th>
            <th>Информация</th>

        </tr>
        <c:forEach items="${geographyList}" var="geographyList">
            <tr>
                <td>${geographyList.id}</td>
                <td>${geographyList.nameCity}</td>
                <td>${geographyList.description}</td>
                <td>
                    <br>
                    <form action="update/${geographyList.id}" method="get">
                        <input type="submit" value="Редактировать">
                    </form>
                    <br>
                    <br>
                    <form action="/delete" method="get">
                        <input type="hidden" name="id" value="${geographyList.id}">
                        <input type="submit" value="удалить">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
