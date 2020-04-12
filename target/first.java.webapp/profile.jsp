<%@ page import="models.UserModel" %><%--
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
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="/profile.css" />
</head>
<body>

<%--<jsp:useBean id="user" class="models.UserModel"/>--%>
<%--<%user = (UserModel) session.getAttribute("user"); %>--%>

<%--<c:set var="u" value="<%=user%>"/>--%>

<header></header>
<main>
    <section>
        <blockquote>
            <picture>
                <img src="/imgs/male.svg"/>
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
            <li>
                <h4>Java</h4>
                <span>
                <span style="width:85%"></span>
            </span>
            </li>
            <li>
                <h4>PHP</h4>
                <span>
                <span style="width:50%"></span>
            </span>
            </li>
            <li>
                <h4>HTML</h4>
                <span>
                <span style="width:40%"></span>
            </span>
            </li>
            <li>
                <h4>CSS</h4>
                <span>
                <span style="width:15%"></span>
            </span>
            </li>
        </ul>
        <ul>
            <h3>Личностни</h3>
            <li>
                <h4>Комуникативност</h4>
                <span>
                <span style="width:40%"></span>
            </span>
            </li>
            <li>
                <h4>Екипна работа</h4>
                <span>
                <span style="width:50%"></span>
            </span>
            </li>
            <li>
                <h4>Креативност</h4>
                <span>
                <span style="width:50%"></span>
            </span>
            </li>
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
                    <c:out value="${user.city}"/>
                </a>
                <h4>Улица</h4>
                <a href="#">
                    <c:out value="${user.street}"/>
                </a>
            </address>
        </blockquote>
    </section>
    <form method="get" action="/profile/edit">
        <input type="submit" value="Edit" />
    </form>
</main>
<footer></footer>
</body>
</html>

