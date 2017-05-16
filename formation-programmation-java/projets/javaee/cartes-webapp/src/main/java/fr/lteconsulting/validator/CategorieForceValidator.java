package fr.lteconsulting.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator
public class CategorieForceValidator implements Validator
{
	@Override
	public void validate( FacesContext context, UIComponent component, Object value ) throws ValidatorException
	{
		UIInput composantForceMin = (UIInput) component.getAttributes().get( "composantForceMin" );

		Integer forceMinValue = (Integer) composantForceMin.getValue();
		Integer forceMaxValue = (Integer) value;

		if( forceMinValue != null && forceMaxValue != null && forceMinValue > forceMaxValue )
			throw new ValidatorException( new FacesMessage( FacesMessage.SEVERITY_ERROR, "Force MAX doit être supérieure à force MIN !", null ) );
	}
}
