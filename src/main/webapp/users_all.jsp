<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Потребители</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/users.css"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:useBean id="usersAll" scope="request" type="java.util.List<services.models.UserModel>"/>
<table>
    <tr class="table-header">
        <th><h3>Потребител</h3></th>
        <th><h3>Работа</h3></th>
        <th><h3>Информация</h3></th>
    </tr>
    <c:forEach var="user" items="${usersAll}">
        <tr>
            <th><a href="${pageContext.request.contextPath}/profile?id=${user.id}"><c:out value="${user.name}"/></a>
            </th>
            <th><c:out value="${user.job}"/></th>
            <th><c:out value="${user.description}"/></th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
