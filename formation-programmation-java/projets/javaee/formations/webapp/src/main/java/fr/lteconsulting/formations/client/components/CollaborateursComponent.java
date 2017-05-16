package fr.lteconsulting.formations.client.components;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnInit;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.formations.client.dto.CollaborateurDTO;
import fr.lteconsulting.formations.client.services.CollaborateurService;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-collaborateurs",
		templateUrl = "CollaborateursComponent.html",
		styles = ".selected { background-color: #bbb; }" )
@JsType
public class CollaborateursComponent implements OnInit
{
	public String filterText;

	public CollaborateurDTO selectedCollaborateur;

	public final String dateFormat = "dd MMM yyyy";

	@JsProperty
	public JsArray<CollaborateurDTO> getCollaborateurs()
	{
		if( _collaborateurs == null )
			return null;
		if( filterText == null )
			return _collaborateurs;

		String realFilter = filterText.toLowerCase();

		return _collaborateurs.filter( c -> (c.nom + " " + c.prenom + " " + c.codeAgence).toLowerCase().contains( realFilter ) );
	}

	private JsArray<CollaborateurDTO> _collaborateurs;

	private CollaborateurService collaborateurService;

	public CollaborateursComponent( CollaborateurService collaborateurService )
	{
		this.collaborateurService = collaborateurService;
	}

	@Override
	public void ngOnInit()
	{
		collaborateurService.getAll()
				.then( result -> {
					_collaborateurs = result;
					return null;
				} );
	}

	public void selectCollaborateur( CollaborateurDTO collaborateur )
	{
		selectedCollaborateur = collaborateur;
	}
}
