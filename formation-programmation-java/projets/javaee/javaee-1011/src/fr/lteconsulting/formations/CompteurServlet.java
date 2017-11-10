package fr.lteconsulting.formations;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/compteur" )
@SuppressWarnings( "serial" )
public class CompteurServlet extends HttpServlet
{
	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		Integer valeurCompteur = (Integer) req
				.getSession()
				.getAttribute( Constantes.SESSION_COMPTEUR_KEY );
		if( valeurCompteur == null )
			valeurCompteur = 0;

		valeurCompteur++;

		req.getSession().setAttribute( Constantes.SESSION_COMPTEUR_KEY, valeurCompteur );

		resp.setContentType( "text/html" );
		resp.getWriter().print( "<html><head></head><body>"
				+ "Compteur = " + valeurCompteur
				+ "<br/><a href='raz'>RAZ</a>"
				+ "</body></html>" );
	}
}
