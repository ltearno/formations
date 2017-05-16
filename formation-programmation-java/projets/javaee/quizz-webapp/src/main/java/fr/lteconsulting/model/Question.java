package fr.lteconsulting.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Question
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@ManyToOne
	private Quizz quizz;

	@OneToMany( mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.ALL )
	private List<Reponse> reponses;

	@Column( columnDefinition = "TEXT" )
	private String texte;

	public Integer getId()
	{
		return id;
	}

	public void setId( Integer id )
	{
		this.id = id;
	}

	public Quizz getQuizz()
	{
		return quizz;
	}

	public void setQuizz( Quizz quizz )
	{
		this.quizz = quizz;
	}

	public String getTexte()
	{
		return texte;
	}

	public void setTexte( String texte )
	{
		this.texte = texte;
	}

	public List<Reponse> getReponses()
	{
		return reponses;
	}

	public void addReponse( Reponse reponse )
	{
		if( reponses == null )
			reponses = new ArrayList<>();

		reponses.add( reponse );
		reponse.setQuestion( this );
	}
}
