package fr.lteconsulting;

import java.util.ArrayList;
import java.util.List;

import fr.lteconsulting.outils.Saisie;

public class Menu
{
	private List<Commande> commandes = new ArrayList<>();

	public void ajouterCommande( Commande commande )
	{
		commandes.add( commande );
	}

	public Commande saisirCommmande()
	{
		// TODO exercice : afficher num�rotation en lettres puis en chiffre romain
		// afficher un menu,
		System.out.println();
		System.out.println( "MENU" );
		for( int i = 0; i < commandes.size(); i++ )
		{
			Commande commande = commandes.get( i );

			System.out.println( "- " + (i + 1) + ". " + commande.getNom() );
		}

		// TODO faire un r�capitulatif des choix
		// TODO g�rer les erreurs de l'utilisateur
		int choix = Saisie.saisieInt( "Faites votre choix" );

		Commande commandeChoisie = commandes.get( choix - 1 );

		return commandeChoisie;
	}
}
