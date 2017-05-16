package fr.lteconsulting.training.struts.model;

public class Marvel
{
	private int id;
	private String nom;
	private String prenom;
	private String couleur;

	public Marvel()
	{
	}

	public Marvel( int id, String nom, String prenom, String couleur )
	{
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.couleur = couleur;
	}

	public void setId( int id )
	{
		this.id = id;
	}

	public void setNom( String nom )
	{
		this.nom = nom;
	}

	public void setPrenom( String prenom )
	{
		this.prenom = prenom;
	}

	public void setCouleur( String couleur )
	{
		this.couleur = couleur;
	}

	public int getId()
	{
		return id;
	}

	public String getNom()
	{
		return nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public String getCouleur()
	{
		return couleur;
	}
}
