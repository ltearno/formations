package fr.lteconsulting.training;

public class RAM
{
	private int capacite;

	public RAM( int capacite )
	{
		this.capacite = capacite;
	}

	public void initialiser()
	{
		System.out.println( "Initialisation mémoire " + capacite + " Go" );
	}

	public void eteindre()
	{
		System.out.println( "Extinction mémoire vive" );
	}
}
