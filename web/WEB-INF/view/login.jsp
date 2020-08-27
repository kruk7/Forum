<%--
  Created by IntelliJ IDEA.
  User: Raven
  Date: 2020-08-27
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forum - Logowanie</title>
</head>
<body>
    <h1>Logowanie</h1>
    <form action="j_security_check" method="post">
        <input type="text" name="j_username" placeholder="Login"><br/>
        <input type="password" name="j_password" placeholder="Haslo"><br/>
        <input type="submit" value="Zaloguj">
    </form>
    <a href="register">Rejestracja</a>
</body>
</html>
