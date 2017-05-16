package fr.lteconsulting;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener
{
	@Override
	public void contextInitialized( ServletContextEvent servletContextEvent )
	{
//		Joueur j1 = new Joueur( "TOTO", "toto", "toto", 'O' );
//		Joueur j2 = new Joueur( "TITI", "titi", "titi", 'I' );
//		DonneesScope.getJoueursApplication( servletContextEvent.getServletContext() ).add( j1 );
//		DonneesScope.getJoueursApplication( servletContextEvent.getServletContext() ).add( j2 );
//
//		Partie p = new Partie( "Partie de base", 3 );
//		p.ajouterJoueur( j1 );
//		DonneesScope.getPartiesApplication( servletContextEvent.getServletContext() ).add( p );
//
//		p = new Partie( "Partie de base en taille 4", 4 );
//		p.ajouterJoueur( j1 );
//		p.ajouterJoueur( j2 );
//		DonneesScope.getPartiesApplication( servletContextEvent.getServletContext() ).add( p );
	}

	@Override
	public void contextDestroyed( ServletContextEvent sce )
	{
	}
}
