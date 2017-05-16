package fr.lteconsulting.servlet;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.dao.EntrepriseDao;
import fr.lteconsulting.dao.UtilisateurDao;
import fr.lteconsulting.ejb.GestionUtilisateur;
import fr.lteconsulting.model.Entreprise;
import fr.lteconsulting.model.Utilisateur;

public class TestServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@EJB
	private UtilisateurDao utilisateurDao;

	@EJB
	private EntrepriseDao entrepriseDao;

	@EJB
	private GestionUtilisateur gestionUtilisateur;

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		response.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html" );

		// charger la liste des entreprises
		Entreprise e = new Entreprise();
		e.setNom( UUID.randomUUID().toString() );
		for( int i = 0; i < 5; i++ )
		{
			Utilisateur u = new Utilisateur();
			u.setNom( UUID.randomUUID().toString() );
			e.addUtilisateur( u );
		}
		entrepriseDao.add( e );

		// charge les utilisateurs
		// pour chaque utilisateur qui n'a pas d'entreprise on lui en donne une

		String message = "";

		String action = request.getParameter( "action" );
		if( action != null )
		{
			switch( action )
			{
				case "add":
					Utilisateur u = new Utilisateur();
					u.setNom( "toto " + UUID.randomUUID() );
					utilisateurDao.addUtilisateur( u );
					message = "Utilisateur ajouté !!";
					break;

				case "delete":
					int id = Integer.parseInt( request.getParameter( "id" ) );
					Utilisateur utilisateur = utilisateurDao.getUtilisateur( id );
					utilisateurDao.removeUtilisateur( utilisateur );
					message = "Utilisateur supprimé !";
					break;

				case "hello":
					message = "BONJOUR !";
					break;
			}
		}

		List<Utilisateur> utilisateurs = utilisateurDao.getUtilisateurs();

		request.setAttribute( "utilisateurs", utilisateurs );
		request.setAttribute( "message", message );

		request.getRequestDispatcher( "/WEB-INF/test.jsp" ).forward( request, response );
	}
}
