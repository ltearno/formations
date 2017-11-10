package fr.lteconsulting.formations;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet( "/hello-session.html" )
public class HelloSessionServlet extends HttpServlet
{
	@Override
	protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		// récupérer le nom de l'utilisateur depuis les données du formulaire
		String nom = req.getParameter( "nom" );

		// si il est présent, l'enregistrer dans la session
		if( nom != null && !nom.isEmpty() )
			req.getSession().setAttribute( "username", nom );

		// renvoyer une redirection vers 'hello-session.html'
		resp.sendRedirect( "hello-session.html" );
	}

	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		// on demande la session
		HttpSession session = req.getSession();

		String userName = (String) session.getAttribute( "username" );

		// le nom de l'utilisateur est-il dans la session ?
		if( userName != null && !userName.isEmpty() )
		{
			// j'ai bien le nom de l'utilisateur dans la session
			resp.setContentType( "text/html" );
			resp.getWriter().print( "Salut mon vieux " + userName + ""
					+ "<br/><a href='logout'>SE DECONNECTER</a>" );
		}
		else
		{
			// afficher le formulaire
			resp.getWriter().print( "<html><head></head><body>"
					+ "<form method='post'>"
					+ "    <input type='text' name='nom'/>"
					+ "    <button>OK</button>"
					+ "</form>"
					+ "</body></html>" );
		}
	}
}
