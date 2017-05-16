package com.sopra.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public interface IWeatherWs
{
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	boolean isWeatherGood();
}
