package fr.lteconsulting;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ScopesServlet
 */
@WebServlet( "/scopes.html" )
public class ScopesServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		// pour les scopes APPLICATION et SESSION,
		// on va inspecter son contenu et associer un nouvel objet si le scope est vide

		// quel est l'objet associé à la clé "plateau" dans le scope APPLICATION ?
		Plateau scopeApplication = (Plateau) getServletContext().getAttribute( "plateauApplication" );
		if( scopeApplication == null )
		{
			scopeApplication = new Plateau( 3, 3 );

			// associer le plateau à la clé "plateau" dans le scope APPLICATION
			getServletContext().setAttribute( "plateauApplication", scopeApplication );
		}

		// quel est l'objet associé à la clé "plateau" dans le scope SESSION ?
		Plateau scopeSession = (Plateau) request.getSession().getAttribute( "plateauSession" );
		if( scopeSession == null )
		{
			scopeSession = new Plateau( 4, 4 );

			// associer le plateau à la clé "plateau" dans le scope SESSION
			request.getSession().setAttribute( "plateauSession", scopeSession );
		}

		// quel est l'objet associé à la clé "plateau" dans le scope REQUEST ?
		Plateau scopeRequest = (Plateau) request.getAttribute( "plateauRequest" );
		if( scopeRequest == null )
		{
			scopeRequest = new Plateau( 5, 5 );

			// associer le plateau à la clé "plateau" dans le scope REQUEST
			request.setAttribute( "plateauRequest", scopeRequest );
		}

		// passer le traitement de la requete à la JSP
		getServletContext()
				.getRequestDispatcher( "/WEB-INF/scopes.jsp" )
				.forward( request, response );
	}
}





