package fr.lteconsulting;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/resetPlateau" )
public class ResetPlateauServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		request.getSession().removeAttribute( "plateau" );

		response.sendRedirect( "jeu.html" );
	}
}
