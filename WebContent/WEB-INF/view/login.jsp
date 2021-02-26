<%@ page language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="fr">

<head>
    <title>Admin</title>
    <link rel="stylesheet" href="assets/css/style.css" type="text/css">
    <link rel="stylesheet" href="assets/css/login.css" type="text/css">
</head>

<body>
    <div class="login">
        <h1>Login</h1>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <input type="text" name="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <button type="submit" class="btn btn-primary btn-block btn-large">Connect</button>
        </form>
    </div>
</body>
<footer>

</footer>

</html>