<%@page import="fr.lteconsulting.formations.Constantes"%>
<form method='post'>
	<label>Entrez votre message s'il vous plait
	<input type='text' name='<%= Constantes.FORM_MESSAGE_FIELD_NAME %>'/></label>
	<button>Envoyer ce message</button>
</form>