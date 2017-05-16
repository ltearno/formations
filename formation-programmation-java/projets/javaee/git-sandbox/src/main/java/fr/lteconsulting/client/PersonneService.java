package fr.lteconsulting.client;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import fr.lteconsulting.shared.Personne;

public interface PersonneService extends RestService
{
	@GET
	void get( MethodCallback<List<Personne>> callback );

	@POST
	void create( Personne personne, MethodCallback<Personne> callback );

	@PUT
	void update( Personne personne, MethodCallback<Personne> callback );

	@DELETE
	@Path( "/{id}" )
	void delete( @PathParam( "id" ) Integer id, MethodCallback<Boolean> callback );

	@GET
	@Path( "/search/{nom}" )
	void searchByName( @PathParam( "nom" ) String nom, MethodCallback<List<Personne>> callback );
}