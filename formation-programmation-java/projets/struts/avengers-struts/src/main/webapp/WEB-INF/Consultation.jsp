<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Consultation</title>
</head>
<body>
Bienvenue ${sessionScope.utilisateur}

<c:forEach items="${marvels}" var="marvel">
    <div>
        <div>${marvel.id}</div>
        <div>${marvel.nom}</div>
        <div>${marvel.prenom}</div>
        <div>${marvel.couleur}</div>

        <a href="edition.action?id=${marvel.id}">editer</a>
        <a href="suppression.action?id=${marvel.id}">supprimer</a>
    </div>
</c:forEach>

<a href="creation.action">ajouter</a>
</body>
</html>
