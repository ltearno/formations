<%@page import="fr.lteconsulting.Utilisateur"%>
<%@page import="fr.lteconsulting.Constantes"%>
<%@page import="fr.lteconsulting.CookieHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	Bonjour cher ${ utilisateur.fullName }<br />kjhkjh
	
	<form method="post">
		<input type="hidden" name="action" value="logout" />
		<button type="submit">Se déconnecter</button>
	</form>

	<p>
		Vous vous êtes connecté à cette date : ${ dateConnection }
	</p>
</body>
</html>
