<%--
  Created by IntelliJ IDEA.
  User: Stefan
  Date: 4/21/2020
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/header.css"/>
</head>
<body>
<%--<jsp:useBean id="user" scope="request" type="services.models.UserModel"/>--%>
<header>
    <section>
        <c:choose>
            <c:when test="${not empty user}">
                <a href="${pageContext.request.contextPath}/logout">Изход</a>
                <a href="${pageContext.request.contextPath}/users/all">Потребители</a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/register">Регистрация</a>
                <a href="${pageContext.request.contextPath}/login">Вход</a>
                <a href="${pageContext.request.contextPath}/users/all">Потребители</a>
            </c:otherwise>
        </c:choose>
    </section>
</header>
</body>
</html>
