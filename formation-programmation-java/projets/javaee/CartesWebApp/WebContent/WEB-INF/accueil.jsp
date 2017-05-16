<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String nomUtilisateur = (String) request.getAttribute( "nomUtilisateur" );
%>

<h1>
	Bienvenue
	<%= nomUtilisateur %>
	!
</h1>

<form method="post" action="logout">
	<input type="hidden" name="action" value="logout" />

	<button class="btn waves-effect waves-light" type="submit">
		Se déconnecter <i class="material-icons right">lock</i>
	</button>
</form>








