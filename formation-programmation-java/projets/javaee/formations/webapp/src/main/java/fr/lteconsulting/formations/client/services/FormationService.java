package fr.lteconsulting.formations.client.services;

import com.google.gwt.core.client.GWT;

import fr.lteconsulting.angular2gwt.client.JSON;
import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.JsObject;
import fr.lteconsulting.angular2gwt.client.interop.angular.rxjs.Observable;
import fr.lteconsulting.angular2gwt.client.interop.ng.http.Headers;
import fr.lteconsulting.angular2gwt.client.interop.ng.http.Http;
import fr.lteconsulting.angular2gwt.client.interop.promise.Promise;
import fr.lteconsulting.angular2gwt.ng.core.Injectable;
import fr.lteconsulting.formations.client.dto.FormationDTO;
import jsinterop.annotations.JsType;

@Injectable
@JsType
public class FormationService
{
	private Http http;

	private static final String baseUrl = "rs/formations";
	private static final Headers headers = new Headers();

	static
	{
		headers.append( "Content-Type", "application/json" );
	}

	public FormationService( Http http )
	{
		this.http = http;
	}

	public Promise<JsArray<FormationDTO>> getAll()
	{
		return http.get( baseUrl )
				.toPromise()
				.<JsArray<FormationDTO>> then( response -> response.json() )
				.onCatch( this::handleError );
	}

	public Promise<FormationDTO> getOne( String id )
	{
		return http.get( baseUrl + "/" + id )
				.toPromise()
				.<FormationDTO> then( response -> response.json() )
				.onCatch( this::handleError );
	}
	
	public Observable<JsArray<FormationDTO>> searchByIntitule( String term )
	{
		return http.get( baseUrl + "/byIntitule/" + term )
				.map( response -> response.json() );
	}

	public Promise<FormationDTO> delete( String id )
	{
		return http.delete( baseUrl + "/" + id )
				.toPromise()
				.<FormationDTO> then( response -> response == null || response.text().isEmpty() ? null : response.json() )
				.onCatch( this::handleError );
	}

	public Promise<FormationDTO> createOrUpdate( FormationDTO formation )
	{
		return http.post( baseUrl,
				JSON.stringify( formation ),
				new JsObject().set( "headers", headers ) )
				.toPromise()
				.<FormationDTO> then( response -> response.json() )
				.onCatch( this::handleError );
	}

	private Promise<?> handleError( Object error )
	{
		// for demo purposes only, one should do more things here !
		GWT.log( "An error occurred" + error );
		return Promise.reject( error );
	}
}
