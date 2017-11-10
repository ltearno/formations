package fr.lteconsulting.ui;

import java.util.List;

import fr.lteconsulting.Menu;
import fr.lteconsulting.commande.Commande;
import fr.lteconsulting.commande.ContexteExecution;
import fr.lteconsulting.modele.Disque;
import fr.lteconsulting.outils.Saisie;

public class SelectionDisque
{
	public static Disque selectionnerDisque( String sousTitre, ContexteExecution contexte )
	{
		// Choix du type de recherche
		ChoixTypeRecherche choixTypeRecherche = new ChoixTypeRecherche();
		Menu menu = new Menu( "Sélection d'un disque pour " + sousTitre );
		menu.ajouterCommande( new ChoixTypeRechercheCommande( "Rechercher un disque par son nom", TypeRecherche.PAR_NOM, choixTypeRecherche ) );
		menu.ajouterCommande( new ChoixTypeRechercheCommande( "Rechercher un disque par son code barre", TypeRecherche.PAR_CODE_BARRE, choixTypeRecherche ) );
		Commande choixRecherche = menu.saisirCommmande();
		choixRecherche.executer( contexte );

		// Les commandes de choix sont censées alimenter l'objet 'choixTypeRecherche'
		TypeRecherche typeRecherche = choixTypeRecherche.getTypeRecherche();

		return selectionnerDisque( typeRecherche, contexte );
	}

	private static Disque selectionnerDisque( TypeRecherche typeRecherche, ContexteExecution contexte )
	{
		switch( typeRecherche )
		{
			case PAR_NOM:
				return selectionnerDisqueParNom( contexte );

			case PAR_CODE_BARRE:
				return selectionnerDisqueParCodeBarre( contexte );

			default:
				return null;
		}
	}

	private static Disque selectionnerDisqueParNom( ContexteExecution contexte )
	{
		String critere = Saisie.saisie( "Quel mot-clé à trouver dans le nom ?" );
		List<Disque> disques = contexte.getBibliotheque().rechercherDisqueParNom( critere );

		if( disques != null && disques.size() == 1 )
		{
			// pas besoin de faire choisir s'il n'y a qu'un seul choix !
			return disques.get( 0 );
		}

		ChoixDisque choixDisque = new ChoixDisque();
		Menu menu = new Menu( "Sélection d'un disque" );
		for( Disque disque : disques )
			menu.ajouterCommande( new ChoixDisqueCommande( disque, choixDisque ) );
		Commande commandeDeSelection = menu.saisirCommmande();
		commandeDeSelection.executer( contexte );

		return choixDisque.getDisque();
	}

	private static Disque selectionnerDisqueParCodeBarre( ContexteExecution contexte )
	{
		String codeBarre = Saisie.saisie( "Quel code barre (extact) à trouver ?" );
		return contexte.getBibliotheque().rechercherDisqueParCodeBarre( codeBarre );
	}
}
