package fr.lteconsulting.commandes;

import java.util.List;

import fr.lteconsulting.ApplicationContext;
import fr.lteconsulting.Bibliotheque;
import fr.lteconsulting.Disque;
import fr.lteconsulting.ICommande;
import fr.lteconsulting.Saisie;

public class RechercherDisquesCommande implements ICommande
{
	@Override
	public String getTitre()
	{
		return "Rechercher des disques";
	}
	
	@Override
	public void executer( ApplicationContext contexte )
	{
		System.out.println( "\n## RECHERCHE DISQUES ##\n" );
		String recherche = Saisie.saisie( "Saisissez la chaine de recherche" );
		rechercherDisques( contexte.getBibliotheque(), recherche );
	}

	private String rechercherDisques( Bibliotheque bibliotheque, String recherche )
	{
		String codeBarre = null;

		System.out.println( "\nRecherche des disques contenant '" + recherche + "'" );
		List<Disque> disques = bibliotheque.rechercherDisques( recherche );
		System.out.println( disques.size() + " disques contiennent le mot " + recherche );
		for( Disque disque : disques )
		{
			if( codeBarre == null )
				codeBarre = disque.getCodeBarre();

			System.out.println( "REFERENCE : " + disque.getCodeBarre() + " NOM:" + disque.getNom() );
		}

		return codeBarre;
	}
}
