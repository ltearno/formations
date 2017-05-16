package fr.lteconsulting;

import java.util.ArrayList;
import java.util.List;

public class Application
{
	private String login;
	private List<String> mots;

	public Application()
	{
		mots = new ArrayList<>();
	}

	public void run()
	{
		login = Saisie.saisie( "Entrez votre login" );

		// Initialisation des commandes disponibles à l'utilisateur
		Menu menu = new Menu();

		menu.addCommande( new AfficherListe(), "show" );
		menu.addCommande( new AfficherNombre(), "size" );
		if( "Arnaud".equals( login ) )
			menu.addCommande( new AjouterMot(), "add" );

		while( true )
		{
			// Proposition de la liste des commandes accessibles
			Commande commande = menu.afficher();

			// Demande de l'exécution de la commande
			if( commande != null )
				commande.execute( mots );
		}
	}
}
