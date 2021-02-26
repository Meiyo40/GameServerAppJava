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
                <form action="${pageContext.request.contextPath}/createUser" method="post">
                    <input type="text" name="username" placeholder="Username" required>
                    <input id="password" type="password" name="password" placeholder="Password" required>
                    <input id="passwordCheck" type="password" name="passwordCheck" placeholder="Password" required>
                    <select name="role">
                        <option value="user">User</option>
                        <option value="admin">Admin</option>
                    </select>
                    <input type="test" name="key" placeholder="Admin Key" required>
                    <button id="submit" type="submit" class="btn btn-primary btn-block btn-large">Create</button>
                    <div id="info"></div>
                </form>
            </div>
        </body>
        <footer>

        </footer>
        <script type="text/javascript" src="assets/js/sec/checker.js"></script>

        </html>