package fr.lteconsulting.commandes;

import fr.lteconsulting.ApplicationContext;
import fr.lteconsulting.ICommande;

public class QuitterCommande implements ICommande
{
	@Override
	public void executer( ApplicationContext contexte )
	{
		System.out.println( "Bye bye !" );
		System.exit( 0 );
	}

	@Override
	public String getTitre()
	{
		return "Quitter";
	}
}
