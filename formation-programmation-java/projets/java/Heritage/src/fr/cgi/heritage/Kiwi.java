package fr.cgi.heritage;

public class Kiwi extends Oiseau
{
	public Kiwi()
	{
		// appeler le constructeur de la classe parente
		// pour donner le nom du Kiwi
		super( "Kiwi" );
	}

	@Override
	public void chante()
	{
		System.out.println( "cui cui" );
	}
}
