package fr.lteconsulting.servlet.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		// Traitement du parametre NOM du formulaire
		String nom = request.getParameter( "NOM" );
		if( nom != null && !nom.isEmpty() )
		{
			request.getSession().setAttribute( "nom", nom );
		}

		response.sendRedirect( "home" );
	}
}
