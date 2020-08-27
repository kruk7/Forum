<%--
  Created by IntelliJ IDEA.
  User: Raven
  Date: 2020-08-27
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forum - Nowy temat</title>
</head>
<body>
    <h1>Załóż nowy temat</h1>
    <form method="post">
        <input type="text" name="title" placeholder="Wpisz tytuł tematu" maxlength="255"><br/>
        <textarea name="content" cols="40" rows="9" placeholder="Wpisz treść tematu"></textarea>
        <input type="submit" value="Dodaj">
    </form>
</body>
</html>
