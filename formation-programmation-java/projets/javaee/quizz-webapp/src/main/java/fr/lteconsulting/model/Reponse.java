package fr.lteconsulting.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Reponse
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@ManyToOne
	private Question question;

	@OneToMany( mappedBy = "reponse" )
	private Set<ReponseUtilisateur> reponsesUtilisateurs;

	@Column( columnDefinition = "TEXT" )
	private String texte;

	private boolean valide;

	public Integer getId()
	{
		return id;
	}

	public void setId( Integer id )
	{
		this.id = id;
	}

	public Question getQuestion()
	{
		return question;
	}

	public void setQuestion( Question question )
	{
		this.question = question;
	}

	public String getTexte()
	{
		return texte;
	}

	public void setTexte( String texte )
	{
		this.texte = texte;
	}

	public boolean isValide()
	{
		return valide;
	}

	public void setValide( boolean valide )
	{
		this.valide = valide;
	}

	public Set<ReponseUtilisateur> getReponsesUtilisateurs()
	{
		return reponsesUtilisateurs;
	}
}
