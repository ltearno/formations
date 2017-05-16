package fr.lteconsulting;

public class Sortilege extends BaseCarte implements ICarte
{
	private String nom;
	@SuppressWarnings( "unused" )
	private String explication;

	public Sortilege( int cout, String nom, String explication )
	{
		super( cout );

		this.nom = nom;
		this.explication = explication;
	}

	@Override
	public void afficher()
	{
		System.out.println( "Un sortilège " + nom + " qui fait " + getCout() + "€" );
	}
}
