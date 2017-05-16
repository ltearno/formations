package fr.lteconsulting;

public class Employe
{
	private String nom;

	public Employe( String nom )
	{
		this.nom = nom;
	}

	public String getNom()
	{
		return nom;
	}

	public double getSalaire( float nbHeuresTravaillees )
	{
		return 0.4 * nbHeuresTravaillees;
	}

	public String getCategorie()
	{
		return "BASE";
	}
}
