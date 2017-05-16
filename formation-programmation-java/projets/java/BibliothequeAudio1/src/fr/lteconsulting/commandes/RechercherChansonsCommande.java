package fr.lteconsulting.commandes;

import java.util.List;

import fr.lteconsulting.ApplicationContext;
import fr.lteconsulting.Bibliotheque;
import fr.lteconsulting.Chanson;
import fr.lteconsulting.Disque;
import fr.lteconsulting.ICommande;
import fr.lteconsulting.Saisie;

public class RechercherChansonsCommande implements ICommande
{
	@Override
	public void executer( ApplicationContext contexte )
	{
		System.out.println( "\n## RECHERCHE CHANSONS ##\n" );
		String recherche = Saisie.saisie( "Saisissez la chaine de recherche" );
		rechercherChansons( contexte.getBibliotheque(), recherche );
	}

	private void rechercherChansons( Bibliotheque bibliotheque, String recherche )
	{
		System.out.println( "\nRecherche des chansons contenant '" + recherche + "'" );

		List<Chanson> chansons = bibliotheque.rechercherChansons( recherche );

		System.out.println( chansons.size() + " chansons contiennent le mot " + recherche );

		for( Chanson chanson : chansons )
		{
			Disque disque = chanson.getDisque();
			System.out.println( "- '" + chanson.getNom() + "' dans le disque " + disque.getNom() + " (ref:" + disque.getCodeBarre() + ")" );
		}
	}

	@Override
	public String getTitre()
	{
		return "Rechercher chanson";
	}
}
