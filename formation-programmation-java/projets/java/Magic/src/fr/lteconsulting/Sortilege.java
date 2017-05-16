package fr.lteconsulting;

public class Sortilege extends Carte
{
	private String nom;
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
		System.out.println( "Un sortilege " + nom );
	}

	public String getNom()
	{
		return nom;
	}

	public String getExplication()
	{
		return explication;
	}

	@Override
	public String toString()
	{
		return "Sortilege [nom=" + nom + ", explication=" + explication + ", getCout()=" + getCout() + "]";
	}

}
