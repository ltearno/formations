package fr.lteconsulting.formations.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity( name = "DemandeFormation" )
@Table( name = "demandeformation" )
public class DemandeFormation
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@ManyToOne
	private Collaborateur collaborateur;

	@ManyToOne
	private Formation formation;

	public Integer getId()
	{
		return id;
	}

	public void setId( Integer id )
	{
		this.id = id;
	}

	public Collaborateur getCollaborateur()
	{
		return collaborateur;
	}

	public void setCollaborateur( Collaborateur collaborateur )
	{
		this.collaborateur = collaborateur;
	}

	public Formation getFormation()
	{
		return formation;
	}

	public void setFormation( Formation formation )
	{
		this.formation = formation;
	}
}
