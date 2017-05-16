package fr.lteconsulting.formations.client.components;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.Event;
import fr.lteconsulting.angular2gwt.client.interop.angular.rxjs.Observable;
import fr.lteconsulting.angular2gwt.client.interop.angular.rxjs.Subject;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnInit;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.angular2gwt.ng.core.Input;
import fr.lteconsulting.formations.client.dto.CollaborateurDTO;
import fr.lteconsulting.formations.client.dto.DemandeFormationDTO;
import fr.lteconsulting.formations.client.dto.FormationDTO;
import fr.lteconsulting.formations.client.services.DemandeFormationService;
import fr.lteconsulting.formations.client.services.FormationService;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-collaborateur",
		templateUrl = "CollaborateurComponent.html" )
@JsType
public class CollaborateurComponent implements OnInit
{
	public boolean addingDemande = false;
	public JsArray<DemandeFormationDTO> demandesFormation;

	public Observable<JsArray<FormationDTO>> formations;

	private DemandeFormationService demandeFormationService;
	private FormationService formationService;
	private CollaborateurDTO _collaborateur;

	private Subject<String> searchTerms = new Subject<>();

	public void searchFormations( String value )
	{
		searchTerms.next( value );
	}

	@Override
	public void ngOnInit()
	{
		formations = searchTerms
				.debounceTime( 300 )
				.distinctUntilChanged()
				.switchMap( ( term, index ) -> {
					if( term != null && !term.isEmpty() )
						return formationService.searchByIntitule( term );
					else
						return Observable.of( JsArray.<FormationDTO> empty() );
				} );
	}

	public CollaborateurComponent( DemandeFormationService demandeFormationService, FormationService formationService )
	{
		this.demandeFormationService = demandeFormationService;
		this.formationService = formationService;
	}

	@Input
	@JsProperty
	public void setCollaborateur( CollaborateurDTO collaborateur )
	{
		addingDemande = false;

		_collaborateur = collaborateur;

		loadDemandesFormation();
	}

	private void loadDemandesFormation()
	{
		demandeFormationService.findByCollaborateur( _collaborateur.id )
				.then( results -> {
					demandesFormation = results;
					return null;
				} );
	}

	@JsProperty
	public CollaborateurDTO getCollaborateur()
	{
		return _collaborateur;
	}

	public void removeDemandeFormation( DemandeFormationDTO demandeFormation, Event event )
	{
		event.preventDefault();
		event.stopPropagation();
		demandeFormationService.delete( demandeFormation.id ).then( res -> {
			loadDemandesFormation();
			return null;
		} );
	}

	public void participateFormation( FormationDTO formation, Event event )
	{
		event.preventDefault();
		event.stopPropagation();
		DemandeFormationDTO demandeFormation = new DemandeFormationDTO();
		demandeFormation.collaborateur = _collaborateur;
		demandeFormation.formation = formation;
		demandeFormationService.createOrUpdate( demandeFormation )
				.then( res -> {
					loadDemandesFormation();
					return null;
				} );
	}
}
