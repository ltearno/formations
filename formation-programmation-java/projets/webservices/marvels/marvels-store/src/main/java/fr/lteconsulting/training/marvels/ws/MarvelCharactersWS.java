package fr.lteconsulting.training.marvels.ws;

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
	MarvelCharactersResult getCharacters( @QueryParam( "ts" ) String timestamp, @QueryParam( "apikey" ) String apiKey, @QueryParam( "hash" ) String hash );
}
