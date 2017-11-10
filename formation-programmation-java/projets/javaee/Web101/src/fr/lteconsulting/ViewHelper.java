package fr.lteconsulting;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewHelper
{
	public static void displayWelcomeView( Utilisateur utilisateur, Date dateConnexion, HttpServletRequest request, HttpServletResponse response )
			throws IOException, ServletException
	{
		request.setAttribute( "utilisateur", utilisateur );
		request.setAttribute( "dateConnection", dateConnexion );

		request.getRequestDispatcher( "/WEB-INF/welcome.jsp" )
				.forward( request, response );
	}

	public static void displayLoginView( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		request.getRequestDispatcher( "/WEB-INF/loginForm.jsp" )
				.forward( request, response );
	}
}
