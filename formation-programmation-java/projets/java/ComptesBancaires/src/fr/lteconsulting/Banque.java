package fr.lteconsulting;

public class Banque
{
	public void transferer( Client debiteur, Client crediteur, double montant )
	{
		System.out.println( "Transaction de " + montant + " de " + debiteur.getNom() + " à " + crediteur.getNom() );

		if( debiteur.getCompte().getSolde() < montant )
		{
			System.out.println( "[ERREUR] TRANSACTION IMPOSSIBLE, LE DEBITEUR SERAIT A DECOUVERT !" );
			return;
		}

		debiteur.getCompte().debiter( montant );
		
		crediteur.getCompte().crediter( montant );
	}

	public void verserInterets( Compte compte )
	{
		if( compte instanceof CompteRemunere )
		{
			CompteRemunere compteRemunere = (CompteRemunere) compte;
			
			double interets = compteRemunere.getTauxInteret() * compte.getSolde();

			System.out.println( "Les intérets s'élèvent à " + interets + " pour l'année" );

			compteRemunere.crediter( interets );
		}
		else
		{
			System.out.println( "Pas d'intéret à verser sur le compte non rémunéré " + compte.getNumeroDeCompte() );
		}
	}
}





