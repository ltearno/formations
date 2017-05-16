package fr.lteconsulting.formations.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity( name = "Formation" )
@Table( name = "formation" )
public class Formation
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	private String intitule;

	private String lieu;

	private Date debutAttendu;

	private Date debutReel;

	private BigDecimal nbJours;

	private String nomPrestataire;

	public Integer getId()
	{
		return id;
	}

	public void setId( Integer id )
	{
		this.id = id;
	}

	public String getIntitule()
	{
		return intitule;
	}

	public void setIntitule( String intitule )
	{
		this.intitule = intitule;
	}

	public String getLieu()
	{
		return lieu;
	}

	public void setLieu( String lieu )
	{
		this.lieu = lieu;
	}

	public Date getDebutAttendu()
	{
		return debutAttendu;
	}

	public void setDebutAttendu( Date debutAttendu )
	{
		this.debutAttendu = debutAttendu;
	}

	public Date getDebutReel()
	{
		return debutReel;
	}

	public void setDebutReel( Date debutReel )
	{
		this.debutReel = debutReel;
	}

	public BigDecimal getNbJours()
	{
		return nbJours;
	}

	public void setNbJours( BigDecimal nbJours )
	{
		this.nbJours = nbJours;
	}

	public String getNomPrestataire()
	{
		return nomPrestataire;
	}

	public void setNomPrestataire( String nomPrestataire )
	{
		this.nomPrestataire = nomPrestataire;
	}

	@Override
	public String toString()
	{
		return "Formation [id=" + id + ", intitule=" + intitule + ", lieu=" + lieu + ", debutAttendu=" + debutAttendu + ", debutReel=" + debutReel + ", nbJours=" + nbJours + ", nomPrestataire=" + nomPrestataire + "]";
	}
}
