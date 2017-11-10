package fr.lteconsulting.commande.impl.modifdisque;

import fr.lteconsulting.Menu;
import fr.lteconsulting.commande.Commande;
import fr.lteconsulting.commande.ContexteExecution;
import fr.lteconsulting.modele.Disque;
import fr.lteconsulting.ui.SelectionDisque;

public class ModifierDisque implements Commande
{
	@Override
	public String getNom()
	{
		return "Modifier un disque";
	}

	@Override
	public void executer( ContexteExecution contexte )
	{
		Disque disque = SelectionDisque.selectionnerDisque( "modification", contexte );
		if( disque == null )
		{
			System.out.println( "Aucun disque sélectionné, on abandonne..." );
			return;
		}

		disque.afficher( false );

		Menu menu = new Menu( "Modification du disque '" + disque.getNom() + "'" );
		menu.ajouterCommande( new ModifierTitreOuCodeBarreDisque( disque ) );
		menu.ajouterCommande( new AjouterChansonDisque( disque ) );
		// TODO menu.ajouterCommande( new SupprimerChansonDisque( disque ) );
		// TODO menu.ajouterCommande( new ModifierChansonDisque( disque ) );

		Commande commande = menu.saisirCommmande();
		commande.executer( contexte );
	}
}
