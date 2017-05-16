package fr.lteconsulting;

public class Terrain implements ICarte
{
	private Couleur couleur;

	public Terrain( Couleur couleur )
	{
		this.couleur = couleur;
	}

	@Override
	public void afficher()
	{
		System.out.println( "Un terrain " + couleur );
	}
}
