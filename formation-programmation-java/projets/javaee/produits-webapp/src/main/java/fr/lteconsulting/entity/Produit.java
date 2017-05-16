package fr.lteconsulting.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produit
{
	@Id
	@GeneratedValue( strategy = GenerationType.TABLE )
	private Integer id;

	private String nom;

	private double poids;

	public Integer getId()
	{
		return id;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom( String nom )
	{
		this.nom = nom;
	}

	public double getPoids()
	{
		return poids;
	}

	public void setPoids( double poids )
	{
		this.poids = poids;
	}
}
