<%@ page language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

            <jsp:useBean id="user" scope="request" class="com.meiyoservices.bo.User"></jsp:useBean>
            <jsp:useBean id="selectedServ" scope="request" class="com.meiyoservices.bo.GameServer"></jsp:useBean>

            <html lang="fr">

            <head>
                <title>Admin</title>
                <link rel="stylesheet" href="assets/css/style.css" type="text/css">
                <link rel="stylesheet" href="assets/css/select.css" type="text/css">
                <link rel="stylesheet" href="assets/css/button.css" type="text/css">
            </head>

            <body>
                <div id="navbar" class="nav-container">
                    <div class="nav-element nav-container">
                        <a href="${pageContext.request.contextPath}/index" class="link nav-title">Home</a>
                    </div>
                    <div class="nav-center nav-container">
                        <div class="nav-element">
                            <form id="ServForm" class="custom-select" action="${pageContext.request.contextPath}/index" method="GET">
                                <select name="servername" id="servername" required>                                    
                                <c:forEach var="game" items="${GAME_SERV}">
                                    <option value="${game.getName()}">${fn:toUpperCase(fn:substring(game.getName(), 0, 1))}${fn:toLowerCase(fn:substring(game.getName(), 1,fn:length(game.getName())))}</option>
                                </c:forEach>
                                <option value="default">Default</option>
                            </select>
                            </form>
                            <input type="submit" value="GET" form="ServForm"></input>
                        </div>
                    </div>
                    <div class="nav-right nav-container">
                        <div class="nav-element">
                            <a href="${pageContext.request.contextPath}/disconnect">Disconnect(${user.getUsername()})</a>
                        </div>
                    </div>
                </div>

                <div id="main-container">
                    <h2>Services</h2>
                    <div id="service-container">
                        <p>
                            GameServer: ${selectedServ.getName()} <br> Uptime: ${selectedServ.getUptime()} <br> LastBoot: ${selectedServ.getLastBoot()}
                        </p>
                        <div id="controlPanel">
                            <a href="${pageContext.request.contextPath}/api/server/update/${selectedServ.getName()}" class="custom-btn btn-green">Update</a>
                            <a href="${pageContext.request.contextPath}/api/server/boot/${selectedServ.getName()}" class="custom-btn btn-blue">Boot</a>
                            <a href="${pageContext.request.contextPath}/api/server/reboot/${selectedServ.getName()}" class="custom-btn btn-yellow">Reboot</a>
                            <a href="${pageContext.request.contextPath}/api/server/stop/${selectedServ.getName()}" class="custom-btn btn-red">Stop</a>
                            <a href="${pageContext.request.contextPath}/api/server/save/${selectedServ.getName()}" class="custom-btn btn-sky">Save</a>
                            <a href="${pageContext.request.contextPath}/file?servername=${selectedServ.getName()}" class="custom-btn btn-white">Download</a>
                        </div>
                    </div>
                    <div id="return-container">

                    </div>
                </div>
            </body>
            <footer>

            </footer>
            <script src="assets/js/select.js"></script>
            <script src="assets/js/adapt.js"></script>
            <script src="assets/js/gameServer.js"></script>
            <script src="https://code.jquery.com/jquery-3.0.0.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

            </html>