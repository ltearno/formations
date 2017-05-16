package fr.lteconsulting.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Utilisateur implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@NotNull
	private String nom;

	@NotNull
	private String prenom;

	@Min( 18 )
	private int age;

	@NotNull
	@Size( min = 4, message = "Le mot de passe doit contenir au moins 4 caractères" )
	private String login;

	@NotNull
	private String motDePasse;

	public String getNomComplet()
	{
		return prenom + " " + nom;
	}

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

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom( String prenom )
	{
		this.prenom = prenom;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge( int age )
	{
		this.age = age;
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin( String login )
	{
		this.login = login;
	}

	public String getMotDePasse()
	{
		return motDePasse;
	}

	public void setMotDePasse( String motDePasse )
	{
		this.motDePasse = motDePasse;
	}
}
