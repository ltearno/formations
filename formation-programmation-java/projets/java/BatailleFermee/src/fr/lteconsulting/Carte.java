package fr.lteconsulting;

public class Carte
{
	private Couleur couleur;
	private int valeur;

	public Carte( Couleur couleur, int valeur )
	{
		this.couleur = couleur;
		this.valeur = valeur;
	}

	public Couleur getCouleur()
	{
		return couleur;
	}

	public int getValeur()
	{
		return valeur;
	}

	@Override
	public String toString()
	{
		return valeur + " de " + couleur;
	}
}
