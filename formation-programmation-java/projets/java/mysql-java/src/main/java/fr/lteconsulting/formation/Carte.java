package fr.lteconsulting.formation;

public class Carte
{
	private int id;
	private String nom;
	private String couleur;

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

	public String getCouleur()
	{
		return couleur;
	}

	public void setCouleur( String couleur )
	{
		this.couleur = couleur;
	}

	@Override
	public String toString()
	{
		return "Carte [id=" + id + ", nom=" + nom + ", couleur=" + couleur + "]";
	}
}
