package fr.lteconsulting.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.lteconsulting.dao.UtilisateurDao;
import fr.lteconsulting.model.Utilisateur;

@Stateless
public class GestionUtilisateur
{
	@EJB
	private UtilisateurDao utilisateurDao;
	
	@EJB
	private GestionEmail gestionEmail;

	public void inscrireUtilisateur( String nom )
	{
		// enregistrer l'utilisateur en base de donnée
		Utilisateur u = new Utilisateur();
		u.setNom( nom );
		utilisateurDao.addUtilisateur( u );

		// plusieurs étapes
		// une des étapes :
		// envoyer un email de confirmation à l'utilisateur
		gestionEmail.envoyerEmail( "toto@toto.com" );
	}
}
