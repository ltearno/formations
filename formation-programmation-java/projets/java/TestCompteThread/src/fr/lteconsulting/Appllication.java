package fr.lteconsulting;

public class Appllication
{
	public static void main( String[] args )
	{
		// créer un compte en banque
		CompteEnBanque compte = new CompteEnBanque( 5000 );

		// crée deux threads
		Thread t1 = new OperationsThread( compte );
		Thread t2 = new OperationsThread( compte );

		// on les lance
		t1.start();
		t2.start();

		// on attend qu'elles aient fini
		try
		{
			t1.join();
			t2.join();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}

		// on affiche le solde
		System.out.println( "solde: " + compte.getSolde() );
	}
}
