<%--
  Created by IntelliJ IDEA.
  User: Raven
  Date: 2020-08-27
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Forum</title>
</head>
<body>
    <h1>Forum</h1>
    <table border="1">
        <tr>
            <th>Temat</th>
            <th>Data</th>
            <th>Autor</th>
        </tr>
        <c:forEach var="topic" items="${topic}">
            <tr>
                <td>
                    <c:url var="url" scope="page" value="/topic">
                        <c:param name="id" value="${topic.id}"/>
                    </c:url>
                    <a href="${url}">${topic.title}</a>
                </td>
                <td><fmt:formatDate value="${topic.date}" dateStyle="short" timeStyle="short" type="both"/></td>
                <td>${topic.user.login}<td/>
            </tr>
        </c:forEach>
    </table>
    <c:url value="/new-topic" var="urlNewTopic" scope="page"/>
    <form action="${urlNewTopic}">
        <input type="submit" value="Nowy Temat"/>
    </form>
    <br/>
    <a href="logout">Wyloguj</a>
</body>
</html>
