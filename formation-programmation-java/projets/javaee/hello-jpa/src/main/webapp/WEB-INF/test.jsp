<%@page import="fr.lteconsulting.model.Utilisateur"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tests JPA</title>
</head>
<body>

	<%= request.getAttribute( "message" ) %>

	<a href="?action=add">AJOUTER UTILISATEUR</a>

	<ul>
		<%
			List<Utilisateur> utilisateurs = (List<Utilisateur>) request.getAttribute( "utilisateurs" );

			for( Utilisateur utilisateur : utilisateurs )
			{
		%>
		<li><%= utilisateur %> <a href="?action=delete&id=<%=utilisateur.getId()%>">EFFACER</a></li>
		<%
			}
		%>
	</ul>

</body>
</html>