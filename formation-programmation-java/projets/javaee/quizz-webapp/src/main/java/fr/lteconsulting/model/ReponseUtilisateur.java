package fr.lteconsulting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ReponseUtilisateur
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@ManyToOne
	private Reponse reponse;

	@ManyToOne
	private Utilisateur utilisateur;

	public Integer getId()
	{
		return id;
	}

	public void setId( Integer id )
	{
		this.id = id;
	}

	public Reponse getReponse()
	{
		return reponse;
	}

	public void setReponse( Reponse reponse )
	{
		this.reponse = reponse;
	}

	public Utilisateur getUtilisateur()
	{
		return utilisateur;
	}

	public void setUtilisateur( Utilisateur utilisateur )
	{
		this.utilisateur = utilisateur;
	}
}
