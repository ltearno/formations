package fr.lteconsulting;

public abstract class Carte
{
	private int cout;

	public Carte( int cout )
	{
		this.cout = cout;
	}

	public abstract void afficher();

	public int getCout()
	{
		return cout;
	}
}
