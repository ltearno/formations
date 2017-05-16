package com.sopra.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sopra.rest.buisness.FunkoPopService;

@Path( "pop" )
public class FunkoPopWs
{
	static FunkoPopService service = new FunkoPopService();

	// READ ALL

	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public List<FunkoPop> getAll()
	{
		return service.findAll();
	}

	// READ ONE : path /pop/IDENTIFIANT

	@GET
	@Path( "{id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public FunkoPop getOne( @PathParam( "id" ) int id )
	{
		return service.findFunkoPopById( id );
	}

	// CREATE

	@PUT
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public FunkoPop create( FunkoPop pop )
	{
		return service.createOrUpdate( pop );
	}

	// UPDATE

	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public FunkoPop update( FunkoPop pop )
	{
		return service.createOrUpdate( pop );
	}

	// DELETE

	@DELETE
	@Path( "{id}" )
	public void delete( @PathParam( "id" ) int id )
	{
		service.delete( id );
	}

	@Path( "search" )
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public List<FunkoPop> search( @QueryParam( "name" ) String name, @QueryParam( "universe" ) String universe )
	{
		return service.search( name, universe );
	}

	@Path( "urgence" )
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public List<FunkoPop> getFunkoPopsToShelter()
	{
		return service.getFunkoPopsToShelter();
	}

	@Path( "travelTime" )
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public int getTravelTime( @QueryParam( "from" ) int fromFunkoPopId, @QueryParam( "to" ) int toFunkoPopId )
	{
		return service.getTravelTime( fromFunkoPopId, toFunkoPopId );
	}
}
