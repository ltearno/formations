package fr.lteconsulting.servlet;

import javax.servlet.ServletContext;

import fr.lteconsulting.ApplicationData;
import fr.lteconsulting.IApplicationData;

public class DataAccess
{
	private static final String APPLICATION_DATA_SERVLET_CONTEXT_ATTRIBUTE_NAME = "ldsjhflskdjhflskdj";

	public static IApplicationData get( ServletContext context )
	{
		return (IApplicationData) context.getAttribute( APPLICATION_DATA_SERVLET_CONTEXT_ATTRIBUTE_NAME );
	}

	public static void registerApplicationData( IApplicationData applicationData, ServletContext context )
	{
		context.setAttribute( APPLICATION_DATA_SERVLET_CONTEXT_ATTRIBUTE_NAME, applicationData );
	}
}
