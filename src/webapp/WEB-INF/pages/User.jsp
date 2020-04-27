<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello!</title>
    <form action="/login" method="post" >
        <button>Logout</button>
    </form>
</head>
<body>
<h1>Hello, ${user.username}!</h1>
<table border="1" width="25%" cellpadding="5">
    <tr>
        <td><p><b>ID</b></p></td>
        <td><p><b>Username</b></p></td>
        <td><p><b>Password</b></p></td>
    </tr>
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
        </tr>
</table>
</body>
</html>
