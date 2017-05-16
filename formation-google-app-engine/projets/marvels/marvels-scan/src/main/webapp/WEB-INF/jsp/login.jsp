<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Marvels Scanner - Login</title>
</head>
<body>
You are not connected. Please use this <a href="<%= UserServiceFactory.getUserService().createLoginURL("/index.jsp")%>">link</a> to connect and use the application.
</body>
</html>
