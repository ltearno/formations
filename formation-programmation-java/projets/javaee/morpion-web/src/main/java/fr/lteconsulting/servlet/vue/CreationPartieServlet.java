package fr.lteconsulting.servlet.vue;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/creationPartie.html" )
public class CreationPartieServlet extends VueServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		vueCreationPartie( req, resp );
	}
}
