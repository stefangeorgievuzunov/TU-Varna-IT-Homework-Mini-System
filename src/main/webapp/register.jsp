<%--
  Created by IntelliJ IDEA.
  User: Stefan
  Date: 3/20/2020
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">
<head>
    <title>Регистрация</title>
    <link rel="stylesheet" type="text/css" href="./CSS/forms.css" />
</head>
<body>
<jsp:include page="header.jsp" />
<div class="reg">
    <h1>Създаване на профил</h1>
    <div class="reg-body">
        <form action="${pageContext.request.contextPath}/register" method="post">
            <label>Име:</label>
            <input type="text" name="name" placeholder="Въведете име за контакт">
            <label>Потребителско име:</label>
            <input type="email" name="email" placeholder="Въведете имейл адрес">
            <label>Парола:</label>
            <input type="password" name="password" placeholder="Въведете парола с поне 8 символа">
            <label>Повторете паролата:</label>
            <input type="password" name="rePassword" placeholder="Въведете парола с поне 8 символа">
            <input type="submit" name="submit" value="Вход">
        </form>
    </div>
</div>
</body>
</html>

