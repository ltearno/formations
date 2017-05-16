package fr.lteconsulting.formations;

public class Personne
{
	private String nom;
	private String prenom;
	private int codePostal;

	public Personne( String nom, String prenom, int codePostal )
	{
		this.nom = nom;
		this.prenom = prenom;
		this.codePostal = codePostal;
	}
	
	@Override
	public String toString()
	{
		return getDescription();
	}

	public String getDescription()
	{
		return nom + " " + prenom + " " + codePostal;
	}

	public String getNom()
	{
		return nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public int getCodePostal()
	{
		return codePostal;
	}
}
