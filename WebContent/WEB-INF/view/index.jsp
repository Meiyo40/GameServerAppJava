<%@ page language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<jsp:useBean
            	id="user"
            	scope="request"
            	class="com.meiyoservices.bo.User"
            ></jsp:useBean>

    <html lang="fr">

    <head>
        <title>Admin</title>
        <link rel="stylesheet" href="assets/css/style.css" type="text/css">
        <link rel="stylesheet" href="assets/css/select.css" type="text/css">
    </head>

    <body>
        <div id="navbar" class="nav-container">
            <div class="nav-element nav-container">
                <a href="" class="link nav-title">Home</a>
            </div>
            <div class="nav-center nav-container">
                <div class="nav-element custom-select">
                    <select name="serverlist" id="serverlist">
                    <option value="default">Servers</option>
                    <option value="server1">Valheim</option>
                </select>
                </div>
                <div class="nav-element">
                    Action2
                </div>
                <div class="nav-element">
                    Action3
                </div>
            </div>
            <div class="nav-right nav-container">
                <div class="nav-element">
                    <a href="${pageContext.request.contextPath}/disconnect">Disconnect(<jsp:getProperty property="username" name="user"></jsp:getProperty>)</a>
                </div>
            </div>
        </div>

        <div id="main-container">
            <h2>Services</h2>            
            
            <div id="service-container">

            </div>
            <div id="return-container">

            </div>
        </div>
    </body>
    <footer>

    </footer>
    <script src="assets/js/select.js"></script>
    <script src="assets/js/adapt.js"></script>

    </html>