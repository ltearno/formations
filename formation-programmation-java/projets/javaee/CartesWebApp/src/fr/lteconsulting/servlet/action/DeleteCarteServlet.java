package fr.lteconsulting.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.servlet.DataAccessServlet;

/**
 * Servlet implementation class DeleteCarteServlet
 */
public class DeleteCarteServlet extends DataAccessServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		try
		{
			String id = request.getParameter( "id" );

			getData().removeCarte( id );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}

		response.sendRedirect( "cartes" );
	}
}
