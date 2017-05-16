package fr.lteconsulting.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Categorie
{
	private Integer id;
	@NotNull
	@Size( min = 2, max = 30, message = "La taille du nom de la catégorie doit être compris entre 2 et 30 !" )
	private String nom;
	private int forceMin;
	private int forceMax;

	public Integer getId()
	{
		return id;
	}

	public void setId( Integer id )
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

	public int getForceMin()
	{
		return forceMin;
	}

	public void setForceMin( int forceMin )
	{
		this.forceMin = forceMin;
	}

	public int getForceMax()
	{
		return forceMax;
	}

	public void setForceMax( int forceMax )
	{
		this.forceMax = forceMax;
	}

	@Override
	public String toString()
	{
		return "Categorie [id=" + id + ", nom=" + nom + ", forceMin=" + forceMin + ", forceMax=" + forceMax + "]";
	}
}
