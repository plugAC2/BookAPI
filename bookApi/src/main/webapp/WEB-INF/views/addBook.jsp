<%--
  Created by IntelliJ IDEA.
  User: plugactwo
  Date: 27.02.2021
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a book to API</title>
</head>
<body>
    <form method="post">
        <p style="font-size: large">
            Formularz dodawania ksiązki do API
        </p>
        <label>ISBN
            <input type="text" name="isbn">
        </label>
        <label>Title
            <input type="text" name="title">
        </label>
        <label>Author
            <input type="text" name="author">
        </label>
        <label>Publishing House
            <input type="text" name="publisher">
        </label>
        <label>Genre
            <input type="text" name="type">
        </label>
        <input type="submit" value="Dodaj">
    </form>
</body>
</html>
