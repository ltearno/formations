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

	<%
			String nomUtilisateur = (String) session.getAttribute( "A" );

		if("logout".equals(request.getParameter( "action" ))){
			session.invalidate( );
			nomUtilisateur = null;
			
			%><h2>Vous êtes maintenant déconnecté</h2><%
		}
	
		if( nomUtilisateur == null )
		{
			String paramUtilisateur = request.getParameter( Constantes.LOGIN_FORM_NAME_PARAMETER_NAME );
			if( paramUtilisateur == null )
			{
				// AFFICHER LE FORMULAIRE
				%>
				<form method='POST'>
					<input type="text" name="<%= Constantes.LOGIN_FORM_NAME_PARAMETER_NAME %>" />
					<button type="submit">SE CONNECTER</button>
				</form>
				<%
			}
			else
			{
				// enregistrer le cookie
				session.setAttribute( "A", paramUtilisateur );
				nomUtilisateur = paramUtilisateur;
			}
		}
		
		if( nomUtilisateur != null )
		{
			// AFFICHER LE BONJOUR
			%>
			Bonjour cher
			<%= nomUtilisateur %>
			<br/><br/><br/><br/><br/>
			<form method="post">
				<input type="hidden" name="action" value="logout" />
				<button type="submit">Se déconnecter</button>
			</form>
			<%
		}
	%>

</body>
</html>