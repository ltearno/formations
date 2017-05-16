package fr.lteconsulting.validator;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import fr.lteconsulting.dao.UtilisateurDao;
import fr.lteconsulting.model.Utilisateur;

@ManagedBean
@RequestScoped
public class UtilisateurExistenceValidator implements Validator
{
	@EJB
	UtilisateurDao dao;

	@Override
	public void validate( FacesContext context, UIComponent component, Object value ) throws ValidatorException
	{
		Integer recordId = (Integer) component.getAttributes().get( "recordId" );

		String login = (String) value;

		Utilisateur existing = dao.trouverUtilisateurParEmail( login );
		if( existing != null && existing.getId() != recordId )
			throw new ValidatorException( new FacesMessage( FacesMessage.SEVERITY_ERROR, "Ce login est déjà pris !!!", null ) );
	}
}
