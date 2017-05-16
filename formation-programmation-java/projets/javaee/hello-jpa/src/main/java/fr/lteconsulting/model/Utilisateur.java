package fr.lteconsulting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Utilisateur
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;

	@ManyToOne
	private Entreprise entreprise;

	private String nom;

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

	public Entreprise getEntreprise()
	{
		return entreprise;
	}

	public void setEntreprise( Entreprise entreprise )
	{
		this.entreprise = entreprise;
	}

	@Override
	public String toString()
	{
		return "Utilisateur [id=" + id + ", nom=" + nom + "]";
	}
}
