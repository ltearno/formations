package fr.lteconsulting;

public class Application
{
	public static void main( String[] args )
	{
		Banque banque = new Banque();

		banque.ajouterCompte( new CompteCourant( "FR134", 15 ) );
		banque.ajouterCompte( new CompteCourant( "FR133", 215 ) );
		banque.ajouterCompte( new CompteCourant( "FR132", 5 ) );
		banque.ajouterCompte( new CompteCourant( "FR131", 0 ) );
		banque.ajouterCompte( new CompteRemunere( "RR213", 2500, 0.10 ) );
		banque.ajouterCompte( new CompteRemunere( "RR215", 250, 0.05 ) );
		banque.ajouterCompte( new CompteRemunere( "RR211", 500, 0.5 ) );
		banque.ajouterCompte( new CompteRemunere( "RR216", 540, 0.20 ) );

		banque.bilan();

		try
		{
			banque.effectuerVirement( "ZZFR133", "TOTOTO", 215 );
		}
		catch( CompteInexistantException e )
		{
			System.err.println( "ATTENTION Compte " + e.getMessage() + " " + e.getIbanDemande() + " inexistant!" );
		}

		try
		{
			banque.effectuerVirement( "RR216", "FR131", 40 );
		}
		catch( CompteInexistantException e )
		{
			System.err.println( "ATTENTION Compte " + e.getIbanDemande() + " inexistant!" );
		}

		banque.bilan();

		banque.effectuerOperationsAnnuelles();

		banque.bilan();
	}
}
