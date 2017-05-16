package fr.lteconsulting.servlet.vue;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.lteconsulting.Joueur;
import fr.lteconsulting.Partie;
import fr.lteconsulting.Plateau;

public abstract class VueServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void vueAccueil( Joueur joueur, List<Partie> parties, HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		request.setAttribute( "joueur", joueur );
		request.setAttribute( "parties", parties );

		callJsp( "Accueil", false, "accueil", request, response );
	}

	protected void vueLogin( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		callJsp( "Connexion joueur", false, "login", request, response );
	}

	protected void vueCreationCompte( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		callJsp( "Créaton de compte", false, "creationCompte", request, response );
	}

	protected void vueCreationPartie( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		callJsp( "Création d'une partie", false, "creationPartie", request, response );
	}

	protected void vuePartieEnAttente( Partie partie, HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		request.setAttribute( "partie", partie );

		callJsp( "Partie '" + partie.getNom() + "' en attente", true, "partieAttente", request, response );
	}

	protected void vuePartie( Joueur joueur, Plateau plateau, Partie partie, boolean peutJouer, HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		request.setAttribute( "plateau", plateau );
		request.setAttribute( "identifiantPartie", partie.getId() );
		request.setAttribute( "peutJouer", peutJouer );

		Gson gson = new Gson();
		String plateauJson = gson.toJson( plateau );
		request.setAttribute( "plateauJson", plateauJson );

		try
		{
			gson = new GsonBuilder()
					.excludeFieldsWithoutExposeAnnotation()
					.create();
			String joueurConnecte = gson.toJson( joueur );
			request.setAttribute( "joueurConnecte", joueurConnecte );
		}
		catch( Exception e )
		{
			e.printStackTrace();
			request.setAttribute( "joueurConnecte", "null" );
		}

		callJsp( "Partie '" + partie.getNom() + "'", false, "partie", request, response );
	}

	/**
	 * Délègue le traitement de la requete HTTP à une servlet JSP
	 * 
	 * @param name Le nom de la JSP (qui doit se trouver dans le répertoire '/WEB-INF/')
	 * @param request La requete HTTP en cours
	 * @param response La réponse HTTP à générer
	 * @throws IOException
	 * @throws ServletException
	 */
	private void callJsp( String pageTitle, boolean autoReload, String name, HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		request.setAttribute( "pageTitle", pageTitle );
		request.setAttribute( "pageReload", autoReload );
		request.setAttribute( "pageContentJsp", name + ".jsp" );

		getServletContext()
				.getRequestDispatcher( "/WEB-INF/gabarit.jsp" )
				.forward( request, response );
	}
}
