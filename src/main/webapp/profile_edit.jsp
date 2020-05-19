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
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/profile.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/fetch.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:useBean id="user" scope="request" type="services.models.UserModel"/>
<main>
    <h2>Профилна информация</h2>
    <button type="button" onclick="personal(<c:out value="${user.id}"/>)">Запазване</button>
        <section>
            <blockquote>
                <picture>
                    <img src="${pageContext.request.contextPath}/imgs/male.svg"/>
                </picture>
                <aside>
                    <h4>
                        Име:
                        <input type="text" id="name" value='<c:out value="${user.name}"/>'/>
                    </h4>
                    <h4>
                        Работа:
                        <input type="text" id="job" value='<c:out value="${user.job}"/>'/>
                    </h4>
                    <p>
                        <textarea id="desc" cols="60" rows="5" placeholder="Описание...">
                            <c:out value="${user.description}"/>
                        </textarea>
                    </p>
                </aside>
            </blockquote>
        </section>
    <h2>Умения</h2>
    <%--    <form method="post" action="${pageContext.request.contextPath}/profile/edit/skills">--%>
    <%--        <input type="submit" onclick="skills(<c:out value="${user.id}"/>)" value="Запазване"/>--%>
    <button type="button" onclick="skills(<c:out value="${user.id}"/>)">Запазване</button>
    <section>
        <ul>
            <h3>Професионални</h3>
            <c:forEach begin="1" end="${10-user.programmingSkills.size()}" varStatus="loop">
                <li>
                    <input type="text" name="programmingSkillNames[]" value="Умение"/>
                    <input class="slider" name="programmingSkillValues[]" type="range" min="0" max="100"
                           value="0"/>
                </li>
            </c:forEach>
            <c:forEach var="skill" items="${user.programmingSkills}">
                <li>
                    <input type="text" name="programmingSkillNames[]" value='<c:out value="${skill.name}"/>'/>
                    <input class="slider" name="programmingSkillValues[]" type="range" min="0" max="100"
                           value='<c:out value="${skill.value}"/>'/>
                </li>
            </c:forEach>

        </ul>
        <ul>
            <h3>Личностни</h3>
            <c:forEach begin="1" end="${6-user.socialSkills.size()}" varStatus="loop">
                <li>
                    <input type="text" name="socialSkillNames[]" value="Умение"/>
                    <input class="slider" name="socialSkillValues[]" type="range" min="0" max="100"
                           value="0"/>
                </li>
            </c:forEach>
            <c:forEach var="skill" items="${user.socialSkills}">
                <li>
                    <input type="text" name="socialSkillNames[]" value='<c:out value="${skill.name}"/>'/>
                    <input class="slider" name="socialSkillValues[]" type="range" min="0" max="100"
                           value='<c:out value="${skill.value}"/>'/>
                </li>
            </c:forEach>
        </ul>
    </section>
    <%--    </form>--%>
    <h2>Контакти</h2>
    <button type="button" onclick="contacts(<c:out value="${user.id}"/>)">Запазване</button>
        <section>
            <blockquote>
                <address>
                    <h4>Имейл</h4>
                    <c:out value="${user.email}"/>
                    <h4>Телефон</h4>
                    <input type="text" id="phoneNumber" value='<c:out value="${user.phoneNumber}"/>'/>
                </address>
                <address>
                    <h4>Град</h4>
                    <input type="text" id="city" value='<c:out value="${user.address.city}"/>'/>
                    <h4>Улица</h4>
                    <input type="text" id="street" value='<c:out value="${user.address.street}"/>'/>
                </address>
            </blockquote>
        </section>
    <form action="${pageContext.request.contextPath}/profile?id=<c:out value="${user.id}"/>">
        <input type="submit" value="Преглед"/>
    </form>
</main>
<footer></footer>
</body>
</html>

