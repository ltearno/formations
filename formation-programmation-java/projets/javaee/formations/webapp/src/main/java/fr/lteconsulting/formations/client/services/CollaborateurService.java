package fr.lteconsulting.formations.client.services;

import com.google.gwt.core.client.GWT;

import fr.lteconsulting.angular2gwt.client.JSON;
import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.JsObject;
import fr.lteconsulting.angular2gwt.client.interop.ng.http.Headers;
import fr.lteconsulting.angular2gwt.client.interop.ng.http.Http;
import fr.lteconsulting.angular2gwt.client.interop.promise.Promise;
import fr.lteconsulting.angular2gwt.ng.core.Injectable;
import fr.lteconsulting.formations.client.dto.CollaborateurDTO;
import jsinterop.annotations.JsType;

@Injectable
@JsType
public class CollaborateurService
{
	private Http http;

	private static final String baseUrl = "rs/collaborateurs";
	private static final Headers headers = new Headers();

	static
	{
		headers.append( "Content-Type", "application/json" );
	}

	public CollaborateurService( Http http )
	{
		this.http = http;
	}

	public Promise<JsArray<CollaborateurDTO>> getAll()
	{
		return http.get( baseUrl )
				.toPromise()
				.<JsArray<CollaborateurDTO>> then( response -> response.json() )
				.onCatch( this::handleError );
	}

	public Promise<CollaborateurDTO> getOne( String id )
	{
		return http.get( baseUrl + "/" + id )
				.toPromise()
				.<CollaborateurDTO> then( response -> response.json() )
				.onCatch( this::handleError );
	}

	public Promise<CollaborateurDTO> delete( String id )
	{
		return http.delete( baseUrl + "/" + id )
				.toPromise()
				.<CollaborateurDTO> then( response -> response == null || response.text().isEmpty() ? null : response.json() )
				.onCatch( this::handleError );
	}

	public Promise<CollaborateurDTO> createOrUpdate( CollaborateurDTO collaborateur )
	{
		return http.post( baseUrl,
				JSON.stringify( collaborateur ),
				new JsObject().set( "headers", headers ) )
				.toPromise()
				.<CollaborateurDTO> then( response -> response.json() )
				.onCatch( this::handleError );
	}

	private Promise<?> handleError( Object error )
	{
		// for demo purposes only, one should do more things here !
		GWT.log( "An error occurred" + error );
		return Promise.reject( error );
	}
}
