package fr.cgi.heritage;

public class Paon extends Oiseau
{
	public Paon( int numero )
	{
		super( "PAON-" + numero );
	}

	public void faitLaRoue()
	{
		System.out.println( "FAIT LA ROUE" );
	}
}
