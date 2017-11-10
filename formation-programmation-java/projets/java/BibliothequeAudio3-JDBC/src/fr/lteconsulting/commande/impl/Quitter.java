package fr.lteconsulting.commande.impl;

import fr.lteconsulting.commande.Commande;
import fr.lteconsulting.commande.ContexteExecution;
import fr.lteconsulting.outils.Saisie;

public class Quitter implements Commande
{
	@Override
	public String getNom()
	{
		return "Quitter l'application";
	}

	@Override
	public void executer( ContexteExecution contexte )
	{
		String reponse = Saisie.saisie( "Voulez-vous vraiment partir ? (oui/non)" );
		if( "oui".equals( reponse ) )
		{
			System.out.println( "Ciao amigo" );
			System.exit( 0 );
		}
	}
}
