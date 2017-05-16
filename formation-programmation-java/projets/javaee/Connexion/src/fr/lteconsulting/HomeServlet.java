package fr.lteconsulting;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeServlet extends HttpServlet
{
	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		// soit on a des utilisateur connectes
		// soit c'est la premiere fois qu'ils viennent

		HttpSession session = req.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute( "utilisateurConnecte" );
		if( utilisateur != null )
		{
			// afficher la page de bienvenue
			afficherBienvenue(utilisateur, req, resp);
		}
		else
		{
			getServletContext().getRequestDispatcher( "/WEB-INF/login.jsp" ).forward( req, resp );
		}
	}

	@Override
	protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		String nom = req.getParameter( Constantes.RQ_PARAM_NOM_UTILISATEUR );
		// TODO vérifier que le nom n'est pas vide

		// enregistrer l'utilisateur dans la session
		Utilisateur utilisateur = new Utilisateur( nom );
		req.getSession().setAttribute( "utilisateurConnecte", utilisateur );

		afficherBienvenue( utilisateur, req, resp );
	}

	private void afficherBienvenue( Utilisateur utilisateur, HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		session.getAttribute( "kjhkjh" );
		
		// envoyer la page de bienvenue
		req.setAttribute( "nomUtilisateur", utilisateur.getNom() );
		getServletContext()
			.getRequestDispatcher( "/WEB-INF/accueil.jsp" )
			.forward( req, resp );
	}
}







