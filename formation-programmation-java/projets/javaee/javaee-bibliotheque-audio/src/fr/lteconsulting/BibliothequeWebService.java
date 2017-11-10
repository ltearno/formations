package fr.lteconsulting;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import fr.lteconsulting.modele.Bibliotheque;
import fr.lteconsulting.modele.Chanson;
import fr.lteconsulting.modele.Disque;
import fr.lteconsulting.outils.GenerateurDisque;

@Path( "bibliotheque" )
public class BibliothequeWebService
{
	private static final Bibliotheque bibliotheque = new Bibliotheque();

	static
	{
		GenerateurDisque generateur = new GenerateurDisque();
		for( int i = 0; i < 50; i++ )
			bibliotheque.ajouterDisque( generateur.genererDisque() );

		Disque disqueFixe = generateur.genererDisque();
		disqueFixe.setCodeBarre( "idefix" );
		bibliotheque.ajouterDisque( disqueFixe );
	}

	@Path( "disques" )
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public Collection<Disque> getDisques()
	{
		return bibliotheque.getDisques();
	}

	@Path( "disques/search" )
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public Collection<Disque> searchDisques( @QueryParam( "name" ) String nom )
	{
		return bibliotheque.rechercherDisqueParNom( nom );
	}

	@Path( "disques/{id}" )
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public Disque getDisque( @PathParam( "id" ) String id )
	{
		return bibliotheque.rechercherDisqueParCodeBarre( id );
	}

	@Path( "disques/{id}/duree" )
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public Integer getDureeDisque( @PathParam( "id" ) String id )
	{
		Disque disque = bibliotheque.rechercherDisqueParCodeBarre( id );
		if( disque == null )
			return null;

		return disque.getDuree();
	}

	@Path( "disques/{id}/chansons" )
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public Collection<Chanson> getChansons( @PathParam( "id" ) String disqueId )
	{
		Disque disque = bibliotheque.rechercherDisqueParCodeBarre( disqueId );
		if( disque == null )
			return null;

		return disque.getChansons();
	}

	@Path( "disques/{id}/chansons/{no}" )
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public Chanson getChanson( @PathParam( "id" ) String disqueId, @PathParam( "no" ) int numeroChanson )
	{
		Disque disque = bibliotheque.rechercherDisqueParCodeBarre( disqueId );
		if( disque == null )
			return null;

		List<Chanson> chansons = disque.getChansons();
		if( chansons == null || chansons.size() <= numeroChanson )
			return null;

		return chansons.get( numeroChanson );
	}

	@Path( "disques" )
	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Disque ajoutDisque( Disque disque )
	{
		disque.setCodeBarre( UUID.randomUUID().toString() );
		bibliotheque.ajouterDisque( disque );
		return disque;
	}

	@Path( "disques/{id}/chansons" )
	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Chanson ajoutChanson( @PathParam( "id" ) String disqueId, Chanson chanson )
	{
		Disque disque = bibliotheque.rechercherDisqueParCodeBarre( disqueId );
		if( disque == null )
			return null;

		disque.addChanson( chanson );

		return chanson;
	}

	@Path( "disques" )
	@PUT
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Disque updateDisque( Disque disque )
	{
		Disque disqueExistant = bibliotheque.rechercherDisqueParCodeBarre( disque.getCodeBarre() );
		if( disqueExistant == null )
			return null;

		disqueExistant.setNom( disque.getNom() );
		disqueExistant.setChansons( disque.getChansons() );

		return disqueExistant;
	}
}
