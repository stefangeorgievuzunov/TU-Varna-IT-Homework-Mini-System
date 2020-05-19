<%@ page import="services.models.UserModel" %><%--
  Created by IntelliJ IDEA.
  User: Stefan
  Date: 3/22/2020
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en" dir="ltr">
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="./CSS/profile.css"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:useBean id="user" scope="request" type="services.models.UserModel"/>
<jsp:useBean id="loggedUser" scope="request" type="services.models.UserModel"/>
<main>
    <c:if test="${!cookie.containsKey('welcomeMsg')}">
        <form method="get" action="${pageContext.request.contextPath}/profile/close">
            <h2>Добър ден с ТУ Варна</h2>
            <input type="submit" value="Затвори"/>
        </form>
    </c:if>
    <section>
        <blockquote>
            <picture>
                <img src="${pageContext.request.contextPath}/imgs/male.svg"/>
            </picture>
            <aside>
                <h2>Профилна информация</h2>
                <h4>
                    Име:
                    <c:out value="${user.name}"/>
                </h4>
                <h4>
                    Работа:
                    <c:out value="${user.job}"/>
                </h4>
                <h4>Описание:</h4>
                <p>
                    <c:out value="${user.description}"/>
                </p>
            </aside>
        </blockquote>
    </section>
    <h2>Умения</h2>
    <section>
        <ul>
            <h3>Професионални</h3>
            <c:forEach var="skill" items="${user.programmingSkills}">
                <li>
                    <h4><c:out value="${skill.name}"/></h4>
                    <span>
                <span style="width:<c:out value="${skill.value}"/>%"></span>
            </span>
                </li>
            </c:forEach>
        </ul>
        <ul>
            <h3>Личностни</h3>
            <c:forEach var="skill" items="${user.socialSkills}">
                <li>
                    <h4><c:out value="${skill.name}"/></h4>
                    <span>
                <span style="width:<c:out value="${skill.value}"/>%"></span>
            </span>
                </li>
            </c:forEach>
        </ul>
    </section>
    <h2>Контакти</h2>
    <section>
        <blockquote>
            <address>
                <h4>Имейл</h4>
                <a href="#">
                    <c:out value="${user.email}"/>
                </a>
                <h4>Телефон</h4>
                <a href="#">
                    <c:out value="${user.phoneNumber}"/>
                </a>
            </address>
            <address>
                <h4>Град</h4>
                <a href="#">
                    <c:out value="${user.address.city}"/>
                </a>
                <h4>Улица</h4>
                <a href="#">
                    <c:out value="${user.address.street}"/>
                </a>
            </address>
        </blockquote>
    </section>
    <c:if test="${loggedUser.id eq user.id}">
        <form method="get" action="${pageContext.request.contextPath}/profile/edit">
            <input type="submit" value="Редактиране"/>
        </form>
    </c:if>
</main>
<footer></footer>
</body>
</html>

