package fr.lteconsulting.formations.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity( name = "Collaborateur" )
@Table( name = "collaborateur" )
public class Collaborateur
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	private String nom;

	private String prenom;

	private String codeAgence;

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

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom( String prenom )
	{
		this.prenom = prenom;
	}

	public String getCodeAgence()
	{
		return codeAgence;
	}

	public void setCodeAgence( String codeAgence )
	{
		this.codeAgence = codeAgence;
	}
}
