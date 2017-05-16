package fr.lteconsulting;

public class OperationsThread extends Thread
{
	private CompteEnBanque compte;

	public OperationsThread( CompteEnBanque compte )
	{
		this.compte = compte;
	}

	@Override
	public void run()
	{
		for( int i = 0; i < 5000; i++ )
			compte.retrait( 1 );
	}
}
