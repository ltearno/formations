package fr.lteconsulting.servlet.action;

import java.io.IOException;
import java.util.Random;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.dao.CarteDao;
import fr.lteconsulting.model.Carte;

public class GenererCartesServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@EJB
	CarteDao dao;

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		for( int i = 1; i < 100; i++ )
			dao.ajouterCarte( new Carte( nomCarte(), couleur() ) );
		
		response.sendRedirect( "cartes" );
	}

	private String syllabe()
	{
		String[] mots = { "jon", "snow", "meli", "sa", "roi", "da", "me", "pick", "a", "chou", "fou", "bat", "man", "woman", "tra", "tri", "bou", "belz", "crat" };

		return mots[new Random().nextInt( mots.length )];
	}

	private String nomCarte()
	{
		int nbSyllabes = 1 + new Random().nextInt( 3 );

		StringBuilder sb = new StringBuilder();
		while( nbSyllabes-- > 0 )
			sb.append( syllabe() );

		String res = sb.toString();

		return res.substring( 0, 1 ).toUpperCase() + res.substring( 1 );
	}

	private String couleur()
	{
		String res = "#";
		for( int i = 0; i < 6; i++ )
			res += "" + new Random().nextInt( 10 );
		return res;
	}
}
