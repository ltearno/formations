package fr.lteconsulting.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Disque
{
	private String codeBarre;
	private String nom;
	private List<Chanson> chansons = new ArrayList<>();

	public Disque()
	{
	}

	public Disque( String nom )
	{
		this( UUID.randomUUID().toString(), nom );
	}

	public Disque( String codeBarre, String nom )
	{
		this.codeBarre = codeBarre;
		this.nom = nom;
	}

	public String getCodeBarre()
	{
		return codeBarre;
	}

	public void setCodeBarre( String codeBarre )
	{
		this.codeBarre = codeBarre;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom( String nom )
	{
		this.nom = nom;
	}

	public void addChanson( Chanson chanson )
	{
		chansons.add( chanson );
	}

	public List<Chanson> getChansons()
	{
		return chansons;
	}

	public int getDuree()
	{
		int duree = 0;

		for( Chanson chanson : chansons )
			duree += chanson.getDureeEnSecondes();

		return duree;
	}

	public void afficher()
	{
		afficher( true );
	}

	public void afficher( boolean avecTitres )
	{
		System.out.println( "DISQUE [" + codeBarre + "] " + nom + ", durée: " + getDuree() );
		if( avecTitres )
		{
			for( Chanson chanson : chansons )
				chanson.afficher();
		}
	}
}
