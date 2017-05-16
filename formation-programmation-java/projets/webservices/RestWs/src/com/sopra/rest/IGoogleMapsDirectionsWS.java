package com.sopra.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sopra.rest.directions.DirectionsResult;

public interface IGoogleMapsDirectionsWS
{
	@GET
	@Path( "directions/json" )
	@Produces( MediaType.APPLICATION_JSON )
	DirectionsResult getTravelTime(
			@QueryParam( "origin" ) String origin,
			@QueryParam( "destination" ) String destination,
			@QueryParam( "key" ) String key );
}
