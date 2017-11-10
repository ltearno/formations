package fr.lteconsulting.commandes;

import fr.lteconsulting.Commande;
import fr.lteconsulting.ContexteCommande;

public class Quitter implements Commande
{
	@Override
	public String getTitre()
	{
		return "Quitter le programme";
	}

	@Override
	public void executer( ContexteCommande contexte )
	{
		System.exit( 0 );
	}
}
