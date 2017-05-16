package fr.lteconsulting;

import fr.lteconsulting.commandes.AffichageDisquesParCodeBarre;
import fr.lteconsulting.commandes.AffichageDisquesParNom;
import fr.lteconsulting.commandes.AjouterDisque;
import fr.lteconsulting.commandes.GenerationDisques;
import fr.lteconsulting.commandes.RechercheParCodeBarre;
import fr.lteconsulting.commandes.RechercheParNom;
import fr.lteconsulting.modele.Bibliotheque;

public class InferfaceUtilisateur
{
	private Menu menu = new Menu();

	public InferfaceUtilisateur( Bibliotheque bibliotheque )
	{
		menu.ajouterCommande( new AjouterDisque( bibliotheque ) );
		menu.ajouterCommande( new RechercheParNom( bibliotheque ) );
		menu.ajouterCommande( new RechercheParCodeBarre( bibliotheque ) );
		menu.ajouterCommande( new GenerationDisques( bibliotheque ) );
		menu.ajouterCommande( new AffichageDisquesParNom( bibliotheque ) );
		menu.ajouterCommande( new AffichageDisquesParCodeBarre( bibliotheque ) );
	}

	public void execute()
	{
		while( true )
		{
			Commande commandeAExecuter = menu.saisirCommmande();

			commandeAExecuter.executer();
		}
	}
}
