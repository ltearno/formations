package fr.lteconsulting.commandes;

import java.util.List;

import fr.lteconsulting.Commande;
import fr.lteconsulting.modele.Bibliotheque;
import fr.lteconsulting.modele.Disque;
import fr.lteconsulting.outils.Saisie;

public class RechercheParNom implements Commande
{
	private Bibliotheque bibliotheque;

	public RechercheParNom( Bibliotheque bibliotheque )
	{
		this.bibliotheque = bibliotheque;
	}

	@Override
	public String getNom()
	{
		return "Rechercher par nom";
	}

	@Override
	public void executer()
	{
		String terme = Saisie.saisie( "Saisissez le terme de recherche" );

		List<Disque> disques = bibliotheque.rechercherDisqueParNom( terme );

		if( disques == null || disques.isEmpty() )
		{
			System.out.println( "Aucun disque ne correspond au terme " + terme );
		}
		else
		{
			System.out.println( "Voici les disques trouv�s" );
			for( Disque disque : disques )
				disque.afficher( false );
		}
	}
}
