<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Marvel scan - Registration</title>
</head>
<body>
Please fill-in your pseudo :
<form action="/registration" method="post">
    <input type="text" name="pseudo" value="<%= request.getAttribute("pseudo") %>"/>
    <button>This is my pseudo</button>
</form>
</body>
</html>
