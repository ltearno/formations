package fr.lteconsulting.formations.client.services;

import com.google.gwt.core.client.GWT;

import fr.lteconsulting.angular2gwt.client.JSON;
import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.JsObject;
import fr.lteconsulting.angular2gwt.client.interop.ng.http.Headers;
import fr.lteconsulting.angular2gwt.client.interop.ng.http.Http;
import fr.lteconsulting.angular2gwt.client.interop.promise.Promise;
import fr.lteconsulting.angular2gwt.ng.core.Injectable;
import fr.lteconsulting.formations.client.dto.DemandeFormationDTO;
import jsinterop.annotations.JsType;

@Injectable
@JsType
public class DemandeFormationService
{
	private Http http;

	private static final String baseUrl = "rs/demandeformations";
	private static final Headers headers = new Headers();

	static
	{
		headers.append( "Content-Type", "application/json" );
	}

	public DemandeFormationService( Http http )
	{
		this.http = http;
	}

	public Promise<JsArray<DemandeFormationDTO>> getAll()
	{
		return http.get( baseUrl )
				.toPromise()
				.<JsArray<DemandeFormationDTO>> then( response -> response.json() )
				.onCatch( this::handleError );
	}
	
	public Promise<JsArray<DemandeFormationDTO>> findByCollaborateur( Integer id )
	{
		return http.get( baseUrl + "/byCollaborateur/" + id )
				.toPromise()
				.<JsArray<DemandeFormationDTO>> then( response -> response.json() )
				.onCatch( this::handleError );
	}

	public Promise<DemandeFormationDTO> getOne( int id )
	{
		return http.get( baseUrl + "/" + id )
				.toPromise()
				.<DemandeFormationDTO> then( response -> response.json() )
				.onCatch( this::handleError );
	}

	public Promise<DemandeFormationDTO> delete( Integer id )
	{
		return http.delete( baseUrl + "/" + id )
				.toPromise()
				.<DemandeFormationDTO> then( response -> response == null || response.text().isEmpty() ? null : response.json() )
				.onCatch( this::handleError );
	}

	public Promise<DemandeFormationDTO> createOrUpdate( DemandeFormationDTO demandeFormation )
	{
		return http.post( baseUrl,
				JSON.stringify( demandeFormation ),
				new JsObject().set( "headers", headers ) )
				.toPromise()
				.<DemandeFormationDTO> then( response -> response.json() )
				.onCatch( this::handleError );
	}

	private Promise<?> handleError( Object error )
	{
		// for demo purposes only, one should do more things here !
		GWT.log( "An error occurred" + error );
		return Promise.reject( error );
	}
}
