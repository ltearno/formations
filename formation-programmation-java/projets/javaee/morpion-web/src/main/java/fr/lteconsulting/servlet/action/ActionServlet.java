package fr.lteconsulting.servlet.action;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.Partie;

public abstract class ActionServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void redirigerReferer( HttpServletRequest request, HttpServletResponse response ) throws IOException
	{
		String redirection = request.getHeader( "referer" );
		if( redirection == null )
			redirection = "index.html";

		response.sendRedirect( redirection );
	}

	protected void redirigerAccueil( HttpServletResponse response ) throws IOException
	{
		response.sendRedirect( "index.html" );
	}

	protected void redirigerPartie( Partie partie, HttpServletResponse response ) throws IOException
	{
		response.sendRedirect( "partie.html?id=" + partie.getId() );
	}
}
