package fr.lteconsulting.shared;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import fr.lteconsulting.client.Sexe;

public class Personne
{
	// TODO devrait etre final aussi
	private int id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private boolean accepteMarketing;
	private Sexe sexe;
	private String motDePasse;
	private String description;

	public Personne()
	{
		this.id = -1;
	}

	public Personne( int id )
	{
		this.id = id;
	}

	@JsonCreator
	public Personne(
			@JsonProperty( "id" ) int id,
			@JsonProperty( "nom" ) String nom,
			@JsonProperty( "prenom" ) String prenom,
			@JsonProperty( "dateNaissance" ) Date dateNaissance,
			@JsonProperty( "accepteMarketing" ) boolean accepteMarketing,
			@JsonProperty( "sexe" ) Sexe sexe,
			@JsonProperty( "motDePasse" ) String motDePasse,
			@JsonProperty( "description" ) String description )
	{
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.accepteMarketing = accepteMarketing;
		this.sexe = sexe;
		this.motDePasse = motDePasse;
		this.description = description;
	}
	
	public String getNomComplet()
	{
		return nom + " " + prenom;
	}

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

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom( String prenom )
	{
		this.prenom = prenom;
	}

	public Date getDateNaissance()
	{
		return dateNaissance;
	}

	public void setDateNaissance( Date dateNaissance )
	{
		this.dateNaissance = dateNaissance;
	}

	public boolean isAccepteMarketing()
	{
		return accepteMarketing;
	}

	public void setAccepteMarketing( boolean accepteMarketing )
	{
		this.accepteMarketing = accepteMarketing;
	}

	public Sexe getSexe()
	{
		return sexe;
	}

	public void setSexe( Sexe sexe )
	{
		this.sexe = sexe;
	}

	public String getMotDePasse()
	{
		return motDePasse;
	}

	public void setMotDePasse( String motDePasse )
	{
		this.motDePasse = motDePasse;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription( String description )
	{
		this.description = description;
	}

	@Override
	public String toString()
	{
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", accepteMarketing=" + accepteMarketing + ", sexe=" + sexe + ", motDePasse=" + motDePasse + ", description=" + description + "]";
	}
}
