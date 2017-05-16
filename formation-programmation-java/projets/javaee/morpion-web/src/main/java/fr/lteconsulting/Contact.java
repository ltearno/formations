package fr.lteconsulting;

public class Contact
{
	// identifiant
	private int id;
	
	private String nom;
	private String prenom;
	private String telephone;
	
	public Contact()
	{
	}

	public Contact( int id, String nom, String prenom, String telephone )
	{
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
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

	public String getPrenom()
	{
		return prenom;
	}

	public String getTelephone()
	{
		return telephone;
	}
}
