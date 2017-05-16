package fr.lteconsulting.servlet.action;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.dao.CarteDao;

/**
 * Servlet implementation class DeleteCarteServlet
 */
public class DeleteCarteServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@EJB
	CarteDao dao;

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		try
		{
			String id = request.getParameter( "id" );
			
			dao.removeCarte( id );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}

		response.sendRedirect( "cartes" );
	}
}
