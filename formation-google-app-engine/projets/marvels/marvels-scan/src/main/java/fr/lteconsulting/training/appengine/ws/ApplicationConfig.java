package fr.lteconsulting.training.appengine.ws;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath( "api" )
public class ApplicationConfig extends Application
{
	private final Set<Class<?>> classes;

	public ApplicationConfig()
	{
		classes = new HashSet<>();
		classes.add( MarvelCommentsWebService.class );
	}

	@Override
	public Set<Class<?>> getClasses()
	{
		return classes;
	}
}
