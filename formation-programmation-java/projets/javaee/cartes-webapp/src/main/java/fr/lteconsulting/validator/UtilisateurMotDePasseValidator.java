package fr.lteconsulting.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator
public class UtilisateurMotDePasseValidator implements Validator
{
	@Override
	public void validate( FacesContext context, UIComponent component, Object value ) throws ValidatorException
	{
		UIInput composantMotDePasse = (UIInput) component.getAttributes().get( "composantMotDePasse" );

		String motDePasseValue = (String) composantMotDePasse.getValue();
		String confirmationMotDePasseValue = (String) value;

		if( motDePasseValue != null && confirmationMotDePasseValue != null && !motDePasseValue.equals( confirmationMotDePasseValue ) )
			throw new ValidatorException( new FacesMessage( FacesMessage.SEVERITY_ERROR, "Le mot de passe et sa confirmation doivent être identiques !", null ) );
	}
}
