package fr.lteconsulting.commande.impl;

import java.util.List;

import fr.lteconsulting.commande.Commande;
import fr.lteconsulting.commande.ContexteExecution;
import fr.lteconsulting.modele.Disque;
import fr.lteconsulting.outils.Saisie;

public class RechercheParNom implements Commande
{
	@Override
	public String getNom()
	{
		return "Rechercher par nom";
	}

	@Override
	public void executer( ContexteExecution contexte )
	{
		String terme = Saisie.saisie( "Saisissez le terme de recherche" );

		List<Disque> disques = contexte.getBibliotheque().rechercherDisqueParNom( terme );

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
