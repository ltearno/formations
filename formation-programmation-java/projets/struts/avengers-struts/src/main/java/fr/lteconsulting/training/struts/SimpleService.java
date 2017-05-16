package fr.lteconsulting.training.struts;

import fr.lteconsulting.training.struts.model.CountriesResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public interface SimpleService
{
	@GET
	@Path( "get/all" )
	@Produces( "application/json" )
	Response getCountries();

	@GET
	@Path( "get/all" )
	@Produces( "application/json" )
	CountriesResponse getCountriesStructured();
}
