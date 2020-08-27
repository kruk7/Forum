<%--
  Created by IntelliJ IDEA.
  User: Raven
  Date: 2020-08-27
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forum - Rejestracja</title>
</head>
<body>
    <h1>Rejestracja</h1>
    ${message}
    <form method="post">
        <input type="text" name="login" placeholder="Login" maxlength="30"/><br/>
        <input type="password" name="password" placeholder="Haslo" maxlength="20"/><br/>
        <input type="password" name="password2" placeholder="Powtóż Haslo" maxlength="20"/><br/>
        <input type="submit" value="Rejestruj">
    </form>
</body>
</html>
