<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h2>Merci de vous connecter</h2>

<form method="post" action="login">
	<input type="hidden" name="action" value="login" />

	<div class="input-field">
		<i class="material-icons prefix">account_circle</i> <input id="login" type="text" class="validate" name="login"> <label for="login">Login</label>
	</div>
	
	<div class="input-field">
		<input id="password" type="password" class="validate" name="password"> <label for="password">Mot de passe</label>
	</div>

	<button class="btn waves-effect waves-light" type="submit">
		Se connecter <i class="material-icons right">send</i>
	</button>
</form>








