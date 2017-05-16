package fr.lteconsulting;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Partie
{
	@Id
	@GeneratedValue( generator = "system-uuid" )
	@GenericGenerator( name = "system-uuid", strategy = "uuid" )
	private String id;

	private String nom;
	
	private Date creationDate;

	@Lob
	private Plateau plateau;

	@ManyToMany( cascade = CascadeType.MERGE, fetch = FetchType.EAGER )
	private List<Joueur> joueurs = new ArrayList<>();
	
	@PrePersist
	protected void initialiserDateCreation()
	{
		creationDate = new Date();
	}

	public Partie( String nom, int taillePlateau )
	{
		this.nom = nom;
		this.plateau = new Plateau( taillePlateau, taillePlateau );
	}

	public Partie()
	{
	}

	public Joueur getJoueurCourant()
	{
		return joueurs.get( getNbPieces() % getJoueurs().size() );
	}

	public String getId()
	{
		return id;
	}
	
	public Date getCreationDate()
	{
		return creationDate;
	}

	public String getNom()
	{
		return nom;
	}

	public Plateau getPlateau()
	{
		return plateau;
	}

	public List<Joueur> getJoueurs()
	{
		return joueurs;
	}

	public void ajouterJoueur( Joueur joueur )
	{
		if( joueurs == null )
			joueurs = new ArrayList<>();

		joueurs.add( joueur );
	}

	public boolean disposePlacePourJoueur( Joueur joueur )
	{
		if( joueurs == null )
			return true;

		// vérification qu'il reste de la place !!
		if( joueurs.size() >= 2 )
			return false;

		// si le joueur joue déjà dans la partie, on répond FALSE
		for( Joueur j : joueurs )
			if( j.getLogin().equals( joueur.getLogin() ) )
				return false;

		return true;
	}

	public boolean jouableParJoueur( Joueur joueur )
	{
		if( joueurs == null || joueurs.size() != 2 )
			return false;

		for( Joueur j : joueurs )
			if( j.getLogin().equals( joueur.getLogin() ) )
				return true;

		return false;
	}

	public boolean observableParJoueur( Joueur joueur )
	{
		return joueurs != null && joueurs.size() == 2 && !jouableParJoueur( joueur );
	}

	private int getNbPieces()
	{
		int count = 0;

		for( int i = 0; i < plateau.getLargeur(); i++ )
			for( int j = 0; j < plateau.getHauteur(); j++ )
				if( plateau.getPiece( i, j ) != null )
					count++;

		return count;
	}
}
