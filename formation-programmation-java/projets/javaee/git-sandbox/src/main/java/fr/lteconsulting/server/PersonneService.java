package fr.lteconsulting.server;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import fr.lteconsulting.client.Sexe;
import fr.lteconsulting.shared.Personne;

@SuppressWarnings( "deprecation" )
@Path( "personnes" )
public class PersonneService
{
	private static int nextId = 1;
	private static Map<Integer, Personne> database = initDatabase();

	@GET
	@Produces( "application/json" )
	public Collection<Personne> get()
	{
		return database.values();
	}

	@GET
	@Path( "/{id}" )
	@Produces( "application/json" )
	public Personne getPersonne( @PathParam( "id" ) int id )
	{
		return database.get( id );
	}

	@POST
	@Consumes( "application/json" )
	@Produces( "application/json" )
	public Personne create( Personne personne )
	{
		personne.setId( nextId++ );

		database.put( personne.getId(), personne );

		return personne;
	}

	@PUT
	@Consumes( "application/json" )
	@Produces( "application/json" )
	public Personne update( Personne personne )
	{
		database.put( personne.getId(), personne );
		return personne;
	}

	@DELETE
	@Path( "/{id}" )
	public boolean delete( @PathParam( "id" ) Integer id )
	{
		return database.remove( id ) != null;
	}

	@GET
	@Produces( "application/json" )
	@Path( "/search/{nom}" )
	public List<Personne> rechercheParNom( @PathParam( "nom" ) String search )
	{
		final String realSearch = search.toLowerCase();

		/*
		 * // Le code suivant est très idiomatique de Java avant la version 8
		 * 
		 * List<Personne> result = new ArrayList<>();
		 * 
		 * for( Personne p : database.values() )
		 * {
		 * if( p.getNomComplet().toLowerCase().contains( realSearch ) )
		 * result.add( p );
		 * }
		 * 
		 * return result;
		 */

		// Voici un code Java 8 exploitant les Streams, beaucoup plus moderne...
		return database.values()
				.stream()
				.filter( p -> p.getNomComplet().toLowerCase().contains( realSearch ) )
				.collect( Collectors.toList() );
	}

	private static Map<Integer, Personne> initDatabase()
	{
		Map<Integer, Personne> database = new HashMap<>();

		for( int i = 0; i < 10; i++ )
		{
			Personne personne = new Personne( nextId++ );
			personne.setNom( Mots.nom() );
			personne.setPrenom( Mots.nom() );
			personne.setDateNaissance( new Date( 79, 7, 13 ) );
			personne.setAccepteMarketing( Math.random() >= 0.5 );
			personne.setSexe( Math.random() >= 0.5 ? Sexe.Homme : Sexe.Femme );
			personne.setMotDePasse( UUID.randomUUID().toString() );
			personne.setDescription( Mots.phrase( 50 ) );

			database.put( personne.getId(), personne );
		}

		return database;
	}
}