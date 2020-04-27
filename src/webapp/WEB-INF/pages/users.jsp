<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>
<c:set var="users" value="${users}"/>
<form action="/login" method="post" >
    <button>Logout</button>
</form>
        <h1>Users</h1>
        <table border="1" width="25%" cellpadding="5">
            <tr>
                <td><p><b>ID</b></p></td>
                <td><p><b>Username</b></p></td>
                <td><p><b>Actions</b></p></td>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>
                        <form action="/admin/delete" method="post">
                        <button name="id" value="${user.id}" type="submit" onclick='this.form.submit()'>Delete</button>
                        </form>
                        <form action="/admin/edit" method="get">
                            <button name = "id" value = "${user.id}" type="submit" onclick='this.form.submit()'>Edit</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
<c:if test="${isVisible}">
    <form action="/admin/edit" method="post">
        Set new First Name
        <input type="text" name="username">
        Set new Last Name
        <input type="text" name="password">
        <input type="submit" name="submit" value="Save">
    </form>
</c:if>
<h1>Add new user</h1>
<p>
    <big><font color="red"><c:out value="${add}"> </c:out></font></big>
</p>
<form action="/admin/add" method="post">
    <p>
        <input type="text" name="username" placeholder="username">
    </p>
    <p>
        <input type="password" name="password" placeholder="password">
    </p>
    <p>
        <input type="text" name="role" placeholder="Role">
    </p>
    <input type = "submit" name = "submit" value = "Add">
</form>
</body>
</html>


