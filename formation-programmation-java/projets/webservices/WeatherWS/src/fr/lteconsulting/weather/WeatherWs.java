package fr.lteconsulting.weather;

import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path( "weather" )
public class WeatherWs
{
	@Path( "isWeatherGood" )
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public boolean isWeatherGood()
	{
		return new Random().nextBoolean();
	}
}
