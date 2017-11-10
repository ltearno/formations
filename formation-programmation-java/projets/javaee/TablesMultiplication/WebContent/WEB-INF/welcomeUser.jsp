<%@page import="fr.lteconsulting.model.ApplicationData"%>
<%@page import="fr.lteconsulting.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	User user = ApplicationData.getConnectedUser( request );
%>

Bonjour
<%= user.getFirstName() %>
<%= user.getLastName() %>

<a href='todolist'>Accéder à la todo-liste</a>

<a href='logout'>Se déconnecter</a>