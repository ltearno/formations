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

import fr.lteconsulting.formations.model.Collaborateur;
import fr.lteconsulting.formations.server.dao.CollaborateursDao;

@Path( "/collaborateurs" )
public class CollaborateursWs
{
	@EJB
	CollaborateursDao dao;

	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public List<Collaborateur> getAll()
	{
		return dao.getAll();
	}

	@GET
	@Path( "{id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public Collaborateur getOne( @PathParam( "id" ) int id )
	{
		return dao.getById( id );
	}

	@PUT
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Collaborateur create( Collaborateur collaborateur )
	{
		return dao.createOrUpdate( collaborateur );
	}

	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Collaborateur update( Collaborateur collaborateur )
	{
		return dao.createOrUpdate( collaborateur );
	}

	@DELETE
	@Path( "{id}" )
	public void delete( @PathParam( "id" ) int id )
	{
		dao.delete( id );
	}
}
