package fr.lteconsulting;

public class Chanson
{
	private String nom;
	private int duree;
	private Disque disque;

	public Chanson( String nom, int duree )
	{
		this.nom = nom;
		this.duree = duree;
	}

	public String getNom()
	{
		return nom;
	}

	public int getDuree()
	{
		return duree;
	}

	public Disque getDisque()
	{
		return disque;
	}

	void setDisque( Disque disque )
	{
		this.disque = disque;
	}

	public void afficher()
	{
		System.out.println( nom + " (" + duree + " s.)" );
	}
}
