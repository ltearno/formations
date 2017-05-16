package fr.lteconsulting.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.DonneesScope;

@WebServlet( "/logout" )
public class LogoutServlet extends ActionServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		traiterRequete( req, resp );
	}

	@Override
	protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		traiterRequete( req, resp );
	}

	protected void traiterRequete( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		DonneesScope.viderSession( request );

		redirigerReferer( request, response );
	}
}
