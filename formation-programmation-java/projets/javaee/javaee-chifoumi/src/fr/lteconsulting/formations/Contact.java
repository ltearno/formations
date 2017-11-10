package fr.lteconsulting.formations;

public class Contact
{
	private int id;
	private String nom;
	private String prenom;
	
	public Contact()
	{
	}

	public Contact( int id, String nom, String prenom )
	{
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	public int getId()
	{
		return id;
	}

	public void setId( int id )
	{
		this.id = id;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom( String nom )
	{
		this.nom = nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom( String prenom )
	{
		this.prenom = prenom;
	}
}
