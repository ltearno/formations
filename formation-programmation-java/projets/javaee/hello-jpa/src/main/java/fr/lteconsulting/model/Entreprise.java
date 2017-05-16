package fr.lteconsulting.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Entreprise
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;

	private String nom;

	@OneToMany( mappedBy = "entreprise", cascade = CascadeType.PERSIST )
	private List<Utilisateur> utilisateurs;

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

	public void addUtilisateur( Utilisateur utilisateur )
	{
		if( utilisateurs == null )
			utilisateurs = new ArrayList<>();

		utilisateurs.add( utilisateur );
		utilisateur.setEntreprise( this );
	}

	public List<Utilisateur> getUtilisateurs()
	{
		return utilisateurs;
	}
}
