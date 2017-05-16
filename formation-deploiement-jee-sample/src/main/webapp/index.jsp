<%@page import="java.lang.management.ManagementFactory"%>
<%@page import="fr.lteconsulting.JWTTools"%>
<%@page import="fr.lteconsulting.Tools"%>
<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Déploiement 101</title>
</head>
<body>
	Server Id : <%= ManagementFactory.getRuntimeMXBean().getName() %><br/>
	
	<br /> Le répertoire de déploiement est :

	<%=System.getProperty("catalina.base")%><br />
	
	Identifiant de session : <%=session.getId()%><br />

	<!-- Session Java EE -->

	<%
		String valeur = (String) session.getAttribute("VALEUR");
	%>

	La clé 'VALEUR' de la session est : <%=valeur%><br />

	<%
		if (valeur == null) {
			valeur = "VALEUR_" + UUID.randomUUID().toString();
			session.setAttribute("VALEUR", valeur);
			
			%>
			Création de la VALEUR de session : <%=valeur %><br />
			<%
		}
	%>


	<!-- Utilisation d'un cookie -->

	<%
		String valeurCookie = Tools.getCookie(request, "MONCOOKIE");
	%>

	La valeur du cookie MONCOOKIE est : <%=valeurCookie%><br />
	
	<%
		if (valeurCookie == null) {
			valeurCookie = "COOKIE_" + UUID.randomUUID().toString();
			response.addCookie(new Cookie("MONCOOKIE", valeurCookie));
			
			%>
			Création du cookie MONCOOKIE : <%=valeurCookie %><br />
			<%
		}
	%>

	<!-- JWT -->

	<%
		String valeurJwt = JWTTools.get("USER_INFO");
	%>

	La valeur encapsulée par JWT est : <%=valeurJwt%><br />
	
	<%
		if (valeurJwt == null) {
			valeurJwt = "JWT_" + UUID.randomUUID().toString();
			JWTTools.put("USER_INFO", valeurJwt);
			
			%>
			Création de la valeur JWT : <%=valeurJwt %><br />
			<%
		}
	%>

</body>
</html>