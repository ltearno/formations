package fr.lteconsulting.formations;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/raz" )
@SuppressWarnings( "serial" )
public class RazServlet extends HttpServlet
{
	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		req.getSession().setAttribute( Constantes.SESSION_COMPTEUR_KEY, 0 );
		resp.sendRedirect( "compteur" );
	}
}
