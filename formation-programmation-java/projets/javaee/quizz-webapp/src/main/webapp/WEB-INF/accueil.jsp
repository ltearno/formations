<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Bienvenue ${nomUtilisateur} !</h1>

<h3>Choisissez votre Quizz</h3>
<ul>
	<c:forEach items="${quizzs}" var="quizz">
		<li><a class="flow-text" href="repondreQuizz?chooseQuizz=${quizz.id}">${quizz.nom}</a></li>
	</c:forEach>
</ul>

<form method="post" action="logout">
	<input type="hidden" name="action" value="logout" />

	<button class="btn waves-effect waves-light" type="submit">
		Se déconnecter <i class="material-icons right">lock</i>
	</button>
</form>