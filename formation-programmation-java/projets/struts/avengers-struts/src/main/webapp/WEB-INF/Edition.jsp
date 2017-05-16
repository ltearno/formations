<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Edition</title>
</head>
<body>
<form method="post">
    <label><input type="text" name="nom" value="${editedMarvel.nom}"></label><br/>
    <label><input type="text" name="prenom" value="${editedMarvel.prenom}"></label><br/>
    <label><input type="text" name="couleur" value="${editedMarvel.couleur}"></label><br/>

    <button>OK</button>
</form>
</body>
</html>
