<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table>
	<tr>
		<th>Partie</th>
		<th>Joueur(s)</th>
		<th>Action</th>
	</tr>

	<c:forEach var="partie" items="${parties}">
		<tr>
			<td>${partie.nom}</td>
			<td><c:forEach var="j" items="${partie.joueurs}">
				<c:if test="${j.id==joueur.id}"><strong>VOUS !</strong></c:if>
				<c:if test="${j.id!=joueur.id}">${j.pseudo}</c:if>
			</c:forEach></td>
			<td>
				<c:if test="${partie.disposePlacePourJoueur(joueur)}">
					<form method="post" action="rejoindrePartie">
						<input type="hidden" name="partie" value="${partie.id}" />
						<button type="submit">REJOINDRE</button>
					</form>
				</c:if>
				<c:if test="${partie.jouableParJoueur(joueur)}">
					<a class="button" href="partie.html?id=${partie.id}">JOUER</a>
				</c:if>
				<c:if test="${partie.observableParJoueur(joueur)}">
					<a class="button button-outline" href="partie.html?id=${partie.id}">OBSERVER</a>
				</c:if>
			</td>
		</tr>
	</c:forEach>
</table>

<a href="creationPartie.html">Créer une partie</a>