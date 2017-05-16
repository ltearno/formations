package fr.cgi.heritage;

public class Oiseau
{
	private String nom;

	public Oiseau( String nom )
	{
		this.nom = nom;
	}

	public void presenteToi()
	{
		System.out.println( "Je m'appelle " + nom );
	}

	public void chante()
	{
		System.out.println( "piou piou" );
	}
}
