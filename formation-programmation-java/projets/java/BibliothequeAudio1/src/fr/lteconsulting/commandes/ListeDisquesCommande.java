package fr.lteconsulting.commandes;

import fr.lteconsulting.ApplicationContext;
import fr.lteconsulting.Disque;

public class ListeDisquesCommande extends CommandeBase
{
	public ListeDisquesCommande()
	{
		super( "Liste des disques" );
	}

	@Override
	public void executer( ApplicationContext contexte )
	{
		for( Disque disque : contexte.getBibliotheque().getDisques() )
			System.out.printf( "%s : %s\n", disque.getCodeBarre(), disque.getNom() );
	}
}
