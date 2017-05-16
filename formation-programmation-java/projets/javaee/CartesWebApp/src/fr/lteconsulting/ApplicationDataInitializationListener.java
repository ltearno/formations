package fr.lteconsulting;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import fr.lteconsulting.servlet.DataAccess;

public class ApplicationDataInitializationListener implements ServletContextListener
{
	public void contextInitialized( ServletContextEvent event )
	{
		System.out.println( "CREATION DU CONTEXTE" );
		
		IApplicationData applicationData = new HashMapApplicationData();

		DataAccess.registerApplicationData( applicationData, event.getServletContext() );
	}

	public void contextDestroyed( ServletContextEvent arg0 )
	{
		System.out.println( "DESTRUCTION DU CONTEXTE" );
	}
}
