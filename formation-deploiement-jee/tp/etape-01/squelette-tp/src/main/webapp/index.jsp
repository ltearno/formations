<%@page import="fr.lteconsulting.Tools"%>
<%@page import="java.util.UUID"%>
<%@page import="java.lang.management.ManagementFactory" %>

	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>

		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Déploiement 101</title>
			<style>
				body {
					font-family: sans-serif;
					display: flex;
					flex-flow: column;
					align-items: center;
				}
			</style>
		</head>

		<body>
			<div>Bonjour, il est <%= new java.util.Date() %>
			</div>
			<div>L'identifiant du serveur est <%= ManagementFactory.getRuntimeMXBean().getName() %>
			</div>
			<div>Le répertoire de déploiement est <%= System.getProperty("catalina.base") %>
			</div>
			<div>Identifiant de session : <%=session.getId()%>
			</div>
			<!-- Session Java EE -->
			<% String valeur=(String) session.getAttribute("VALEUR"); %>
			<div>La clé 'VALEUR' de la session est actuellement : <%=valeur%></div>
			<% if (valeur==null) { 
				valeur="VALEUR_" + UUID.randomUUID().toString();
				session.setAttribute("VALEUR", valeur); %>
			<div>=> Création de la VALEUR de session : <%=valeur %></div>
			<% } %>

			<!-- Utilisation d'un cookie -->
			<% String valeurCookie = Tools.getCookie(request, "MONCOOKIE"); %>
			<div>La valeur du cookie 'MONCOOKIE' est : <%=valeurCookie%></div>
			<% if (valeurCookie == null) {
				valeurCookie = "COOKIE_" + UUID.randomUUID().toString();
				response.addCookie(new Cookie("MONCOOKIE", valeurCookie));
				
				%>
			<div>Création du cookie 'MONCOOKIE' : <%=valeurCookie %></div>
			<% } %>
		</body>

		</html>