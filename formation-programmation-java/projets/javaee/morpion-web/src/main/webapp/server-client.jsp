<%@page import="javax.persistence.metamodel.SetAttribute"%>
<%@page import="fr.lteconsulting.Piece"%>
<%@page import="fr.lteconsulting.Plateau"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
	<!-- Afficher le pseudo de l'utilisateur connecté -->
	${joueur.pseudo}
	
	<script>
	// créer une variable JS qui contient le nom de l'utilisateur connecté
	let joueur = '${joueur.pseudo}';
	
	alert( 'le joueur s apppelle ' + joueur);
	</script>
</body>
</html>