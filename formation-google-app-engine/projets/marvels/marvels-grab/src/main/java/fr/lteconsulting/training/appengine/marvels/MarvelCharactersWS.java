package fr.lteconsulting.training.appengine.marvels;

import fr.lteconsulting.training.appengine.marvels.model.CharacterDataWrapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path( "characters" )
public interface MarvelCharactersWS
{
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	CharacterDataWrapper getCharacters( @QueryParam( "ts" ) String timestamp, @QueryParam( "apikey" ) String apiKey, @QueryParam( "hash" ) String hash, @QueryParam( "offset" ) int offset );
}
