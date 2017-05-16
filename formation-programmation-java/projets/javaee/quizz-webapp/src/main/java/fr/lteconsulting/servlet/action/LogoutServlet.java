package fr.lteconsulting.servlet.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		process( request, response );
	}

	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		process( request, response );
	}

	private void process( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		request.getSession().invalidate();

		response.sendRedirect( "home" );
	}
}
