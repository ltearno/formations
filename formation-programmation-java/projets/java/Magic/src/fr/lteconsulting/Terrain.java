package fr.lteconsulting;

public class Terrain extends Carte
{
	private Couleur couleur;

	public Terrain( Couleur couleur )
	{
		super( 0 );
		this.couleur = couleur;
	}

	public Couleur getCouleur()
	{
		return couleur;
	}

	@Override
	public void afficher()
	{
		System.out.println( "Un terrain " + couleur );
	}

	@Override
	public String toString()
	{
		return "Terrain [couleur=" + couleur + "]";
	}
}
