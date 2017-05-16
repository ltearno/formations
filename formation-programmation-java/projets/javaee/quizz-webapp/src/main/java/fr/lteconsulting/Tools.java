package fr.lteconsulting;

import javax.servlet.http.HttpSession;

import fr.lteconsulting.model.Utilisateur;

public class Tools
{
	public static void connecterUtilisateur( Utilisateur utilisateur, HttpSession session )
	{
		System.out.println( "CONNEXION UTILISATEUR " + utilisateur.getEmail() );
		session.setAttribute( "nom", utilisateur.getNom() );
		session.setAttribute( "utilisateur", utilisateur );
	}
}
