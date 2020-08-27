<%--
  Created by IntelliJ IDEA.
  User: Raven
  Date: 2020-08-27
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Forum - Temat</title>
</head>
<body>
    <h1>Temat: ${topic.title}</h1>
    <table border="1">
        <tr>
            <th>Login</th>
            <th width="500">Treść</th>
            <th>Data</th>
        </tr>
        <tr>
            <td>${topic.user.login}</td>
            <td>${topic.content}</td>
            <td>${topic.date}</td>
        </tr>
        <c:forEach var="post" items="${topic.posts}">
            <tr>
                <td>${post.user.login}</td>
                <td>${post.content}</td>
                <td>${post.date}</td>
            </tr>
        </c:forEach>
    </table>

    <form method="post">
        <input type="hidden" name="id" value="${topic.id}"/>
        <p>Wpisz treść odpowiedzi</p>
        <textarea name="content" cols="40" rows="8"></textarea><br/>
        <input type="submit" value="ok"/>
    </form>
<a href="index">Powtót do strony głównej</a>
</body>
</html>
