package fr.lteconsulting.formations;

public class Contact
{
	private int id;
	private String nom;
	private String telephone;

	public Contact()
	{
	}

	public Contact( int id, String nom, String telephone )
	{
		this.id = id;
		this.nom = nom;
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

	public void setNom( String nom )
	{
		this.nom = nom;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone( String telephone )
	{
		this.telephone = telephone;
	}
}
