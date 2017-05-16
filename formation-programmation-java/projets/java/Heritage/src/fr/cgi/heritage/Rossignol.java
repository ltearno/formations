package fr.cgi.heritage;

public class Rossignol extends Oiseau
{
	public Rossignol()
	{
		this( "Rossignol" );
	}

	public Rossignol( String nom )
	{
		super( nom );
	}

	@Override
	public void chante()
	{
		super.chante();
		System.out.println( "et aussi lalalalalalala" );
	}
}
