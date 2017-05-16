package fr.lteconsulting.validator;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import fr.lteconsulting.dao.CategorieDao;

@FacesValidator
public class CategorieExistenceValidator implements Validator
{
	@EJB
	private CategorieDao dao;

	@Override
	public void validate( FacesContext context, UIComponent component, Object value ) throws ValidatorException
	{
		String nom = (String) value;

		if( false && dao.trouverCategorieParNom( nom ) != null )
		{
			throw new ValidatorException( new FacesMessage( FacesMessage.SEVERITY_ERROR, "Cette catégorie existe déjà !", null ) );
		}
	}
}
