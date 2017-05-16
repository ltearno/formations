package fr.lteconsulting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Carte
{
	@Id
	@GeneratedValue( generator = "system-uuid" )
	@GenericGenerator( name = "system-uuid", strategy = "uuid" )
	private String id;
	
	private String nom;
	
	private String couleur;
	
	public Carte()
	{
	}

	public Carte( String nom, String couleur )
	{
		this.nom = nom;
		this.couleur = couleur;
	}

	public String getId()
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

	public String getCouleur()
	{
		return couleur;
	}

	public void setCouleur( String couleur )
	{
		this.couleur = couleur;
	}
}
