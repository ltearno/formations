package fr.lteconsulting.formations;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/hello.html" )
public class HelloServlet extends HttpServlet
{
	@Override
	protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		doGet( req, resp );
	}

	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		// examiner si la requete contient un parmaètre "nom"
		String nom = req.getParameter( "nom" );

		resp.setContentType( "text/html" );

		if( nom != null && !nom.isEmpty() )
		{
			resp.getWriter().print( "Salut mon vieux " + nom );
		}
		else
		{
			resp.getWriter().print( "<html><head></head><body>"
					+ "<form method='post'>"
					+ "    <input type='text' name='nom'/>"
					+ "    <button>OK</button>"
					+ "</form>"
					+ "</body></html>" );
		}
	}
}
