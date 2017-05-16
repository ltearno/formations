package fr.lteconsulting;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.outil.DonneesScopes;
import fr.lteconsulting.outil.Outils;

@WebServlet( "/index.html" )
public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		User user = DonneesScopes.getConnectedUser( request );
		if( user == null )
		{
			Outils.callJsp( "login", getServletContext(), request, response );
		}
		else
		{
			Outils.callJsp( "connected", getServletContext(), request, response );
		}
	}

	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		String login = request.getParameter( "login" );
		String password = request.getParameter( "password" );

		User user = new User( login, password );

		DonneesScopes.setConnectedUser( user, request );

		Outils.callJsp( "connected", getServletContext(), request, response );
	}

}
