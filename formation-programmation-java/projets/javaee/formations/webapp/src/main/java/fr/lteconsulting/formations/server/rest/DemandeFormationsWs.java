package fr.lteconsulting.formations.server.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.lteconsulting.formations.model.DemandeFormation;
import fr.lteconsulting.formations.server.dao.DemandeFormationsDao;

@Path( "/demandeformations" )
public class DemandeFormationsWs
{
	@EJB
	DemandeFormationsDao dao;

	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public List<DemandeFormation> getAll()
	{
		return dao.getAll();
	}

	@GET
	@Path( "{id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public DemandeFormation getOne( @PathParam( "id" ) int id )
	{
		return dao.getById( id );
	}

	@GET
	@Path( "byCollaborateur/{id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public List<DemandeFormation> findByCollaborateur( @PathParam( "id" ) int id )
	{
		return dao.findByCollaborateur( id );
	}

	@PUT
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public DemandeFormation create( DemandeFormation DemandeFormation )
	{
		return dao.createOrUpdate( DemandeFormation );
	}

	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public DemandeFormation update( DemandeFormation DemandeFormation )
	{
		return dao.createOrUpdate( DemandeFormation );
	}

	@DELETE
	@Path( "{id}" )
	public void delete( @PathParam( "id" ) int id )
	{
		dao.delete( id );
	}
}
