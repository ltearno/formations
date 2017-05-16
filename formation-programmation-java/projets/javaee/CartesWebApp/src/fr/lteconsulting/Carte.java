package fr.lteconsulting;

import java.util.UUID;

public class Carte
{
	private String id;
	private String nom;
	private String couleur;

	public Carte( String nom, String couleur )
	{
		this.id = UUID.randomUUID().toString();
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
