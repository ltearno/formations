package fr.lteconsulting.commandes;

import fr.lteconsulting.Commande;
import fr.lteconsulting.modele.Bibliotheque;
import fr.lteconsulting.modele.Disque;
import fr.lteconsulting.outils.Saisie;

public class RechercheParCodeBarre implements Commande
{
	private Bibliotheque bibliotheque;

	public RechercheParCodeBarre( Bibliotheque bibliotheque )
	{
		this.bibliotheque = bibliotheque;
	}

	@Override
	public String getNom()
	{
		return "Rechercher par code barre";
	}

	@Override
	public void executer()
	{
		String codeBarre = Saisie.saisie( "Saisissez le code barre" );

		Disque disque = bibliotheque.rechercherDisqueParCodeBarre( codeBarre );

		if( disque == null )
		{
			System.out.println( "Il n'y a aucun disque avec le code barre " + codeBarre );
		}
		else
		{
			System.out.println( "Un disque a �t� trouv�" );
			disque.afficher();
		}
	}
}
