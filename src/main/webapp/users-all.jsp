
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Потребители</title>
    <link rel="stylesheet" type="text/css" href="./CSS/users.css" />
</head>
<body>
    <header>
        <section>
            <a href="/register">Регистрация</a>
            <a href="/login">Вход</a>
            <a href="/users/all">Потребители</a>
        </section>
    </header>
    <table>
        <tr class="table-header">
            <th><h5>Потребител</h5></th>
            <th><h5>Работа</h5></th>
            <th><h5>Информация</h5></th>
        </tr>
        <c:forEach var="user" items="${usersAll}">
            <tr>
                <th><c:out value="${user.name}"/></th>
                <th><c:out value="${user.job}"/></th>
                <th><c:out value="${user.description}"/></th>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
