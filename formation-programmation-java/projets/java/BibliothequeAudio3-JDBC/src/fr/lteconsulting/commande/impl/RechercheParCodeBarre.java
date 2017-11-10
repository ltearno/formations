package fr.lteconsulting.commande.impl;

import fr.lteconsulting.commande.Commande;
import fr.lteconsulting.commande.ContexteExecution;
import fr.lteconsulting.modele.Disque;
import fr.lteconsulting.outils.Saisie;

public class RechercheParCodeBarre implements Commande
{
	@Override
	public String getNom()
	{
		return "Rechercher par code barre";
	}

	@Override
	public void executer( ContexteExecution contexte )
	{
		String codeBarre = Saisie.saisie( "Saisissez le code barre" );

		Disque disque = contexte.getBibliotheque().rechercherDisqueParCodeBarre( codeBarre );

		if( disque == null )
		{
			System.out.println( "Il n'y a aucun disque avec le code barre " + codeBarre );
		}
		else
		{
			System.out.println( "Un disque a été trouvé" );
			disque.afficher();
		}
	}
}
