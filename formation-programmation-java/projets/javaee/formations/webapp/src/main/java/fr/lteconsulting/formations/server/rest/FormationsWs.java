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

import fr.lteconsulting.formations.model.Formation;
import fr.lteconsulting.formations.server.dao.FormationsDao;

@Path( "/formations" )
public class FormationsWs
{
	@EJB
	FormationsDao dao;

	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public List<Formation> getAll()
	{
		return dao.getAll();
	}

	@GET
	@Path( "{id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public Formation getOne( @PathParam( "id" ) int id )
	{
		return dao.getById( id );
	}

	@GET
	@Path( "byIntitule/{term}" )
	@Produces( MediaType.APPLICATION_JSON )
	public List<Formation> byIntitule( @PathParam( "term" ) String term )
	{
		return dao.findByIntitule( term );
	}

	@PUT
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Formation create( Formation formation )
	{
		return dao.createOrUpdate( formation );
	}

	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Formation update( Formation formation )
	{
		return dao.createOrUpdate( formation );
	}

	@DELETE
	@Path( "{id}" )
	public void delete( @PathParam( "id" ) int id )
	{
		dao.delete( id );
	}
}
