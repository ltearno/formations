<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h2>Inscription d'un nouvel utilisateur</h2>

<form method="post" action="subscribe">
	<div class="input-field">
		<i class="material-icons prefix">account_circle</i> 
		<input id="nom" type="text" class="validate" name="nom"> <label for="nom">Nom</label>
	</div>
	
	<div class="input-field">
		<input id="prenom" type="text" class="validate" name="prenom"> <label for="prenom">Prénom</label>
	</div>
	
	<div class="input-field">
		<input id="age" type="text" class="validate" name="age"> <label for="age">Age</label>
	</div>

	<div class="input-field">
		<input id="login" type="text" class="validate" name="login"> <label for="login">Login</label>
	</div>
	
	<div class="input-field">
		<input id="password" type="password" class="validate" name="password"> <label for="password">Mot de passe</label>
	</div>

	<button class="btn waves-effect waves-light" type="submit">
		S'inscrire <i class="material-icons right">send</i>
	</button>
</form>








