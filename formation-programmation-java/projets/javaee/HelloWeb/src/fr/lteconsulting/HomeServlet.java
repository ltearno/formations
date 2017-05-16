package fr.lteconsulting;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeServlet extends HttpServlet
{
	/**
	 * Traitement de la requête GET
	 */
	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		// On récupère la session
		HttpSession session = req.getSession();
		
		// La session contient-elle un objet Utilisateur nommé "utilisateurConnecte"
		Utilisateur utilisateur = (Utilisateur) session.getAttribute( Constantes.SESSION_ATTRIBUT_UTILISATEUR_CONNECTE );
		if( utilisateur != null )
		{
			// Si oui, on affiche la page de bienvenue
			afficherBienvenue( utilisateur, req, resp );
		}
		else
		{
			// Sinon on envoie la page de formulaire de connexion
			afficherFormulaireInscription( req, resp );
		}
	}

	/**
	 * Traitement d'une requête POST.
	 * 
	 * Celle-ci provient (forcément) de la validation du formulaire de connexion
	 */
	@Override
	protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		// L'utilisateur a-t-il fourni son nom ?
		String nom = req.getParameter( Constantes.REQUEST_PARAMETER_USER_NAME );
		if( nom != null && !nom.isEmpty() )
		{
			// Si oui, on crée l'objet Utilisateur ...
			Utilisateur utilisateur = new Utilisateur( nom );

			// ... et on l'enregistre dans la session
			req.getSession().setAttribute( Constantes.SESSION_ATTRIBUT_UTILISATEUR_CONNECTE, utilisateur );

			// Puis on envoie la page de bienvenue
			afficherBienvenue( utilisateur, req, resp );
		}
		else
		{
			// L'utilisateur n'a pas fourni de nom, on réenvoie la page de formulaire
			afficherFormulaireInscription( req, resp );
		}
	}

	private void afficherBienvenue( Utilisateur utilisateur, HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		req.setAttribute( Constantes.REQUEST_ATTRIBUTE_NOM_UTILISATEUR, utilisateur.getNom() );

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( "/WEB-INF/accueil.jsp" );

		dispatcher.forward( req, resp );
	}

	private void afficherFormulaireInscription( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( "/WEB-INF/login.jsp" );

		dispatcher.forward( req, resp );
	}
}
