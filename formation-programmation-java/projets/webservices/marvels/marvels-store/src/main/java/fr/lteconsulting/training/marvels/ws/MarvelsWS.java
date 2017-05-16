package fr.lteconsulting.training.marvels.ws;

import fr.lteconsulting.training.marvels.MD5Tools;
import fr.lteconsulting.training.marvels.Marvel;
import fr.lteconsulting.training.marvels.dao.MarvelsDataStore;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/marvels" )
public class MarvelsWS
{
	@EJB
	MarvelsDataStore store;

	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public List<Marvel> getAll()
	{
		String timeStamp = "1";
		String publicKey = "2c4c69c4f2c2fd59cdbe9dc9429d254e";
		String privateKey = "952fb13aeeb2ea14103811d46d3f48461c161918";

		String hash = MD5Tools.md5( timeStamp + privateKey + publicKey );

		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target( "https://gateway.marvel.com:443/v1/public" );
		MarvelCharactersWS service = target.proxy( MarvelCharactersWS.class );
		MarvelCharactersResult marvels = service.getCharacters( timeStamp, publicKey, hash );

		//"https://gateway.marvel.com:443/v1/public/characters?apikey=2c4c69c4f2c2fd59cdbe9dc9429d254e&ts=1&hash=e90e51a3678e8564a6715b97ec7236b2";

		System.out.println( MD5Tools.md5( "1" + "952fb13aeeb2ea14103811d46d3f48461c161918" + "2c4c69c4f2c2fd59cdbe9dc9429d254e" ) );
		return store.getAll();
	}

	@GET
	@Path( "{id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public Marvel getOne( @PathParam( "id" ) String id )
	{
		return store.findById( id );
	}

	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Marvel create( Marvel marvel )
	{
		return store.create( marvel );
	}

	@PUT
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Marvel update( Marvel marvel )
	{
		return store.update( marvel );
	}

	@DELETE
	@Path( "{id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public boolean delete( @PathParam( "id" ) String id )
	{
		return store.remove( id );
	}
}

