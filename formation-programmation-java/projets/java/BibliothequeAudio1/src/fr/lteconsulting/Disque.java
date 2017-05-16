package fr.lteconsulting;

import java.util.ArrayList;
import java.util.List;

public class Disque implements IObservable<Disque>
{
	private String nom;
	private String codeBarre;
	private List<Chanson> chansons;

	private Observable<Disque> observable = new Observable<>( this );

	public Disque( String nom, String codeBarre )
	{
		this.nom = nom;
		this.codeBarre = codeBarre;
		this.chansons = new ArrayList<>();
	}

	@Override
	public IObservableRegistration registerObserver( IObserver<Disque> observer )
	{
		return observable.registerObserver( observer );
	}

	public void addChanson( Chanson chanson )
	{
		chansons.add( chanson );
		chanson.setDisque( this );
	}

	public int getDuree()
	{
		int duree = 0;
		for( Chanson chanson : chansons )
			duree += chanson.getDuree();
		return duree;
	}

	public String getNom()
	{
		return nom;
	}

	public String getCodeBarre()
	{
		return codeBarre;
	}

	public void setCodeBarre( String codeBarre )
	{
		this.codeBarre = codeBarre;

		observable.notifyObservers();
	}

	public List<Chanson> getChansons()
	{
		return chansons;
	}

	public void afficher()
	{
		System.out.println( "DISQUE " + nom + " REFERENCE : " + codeBarre );
		for( int i = 0; i < chansons.size(); i++ )
		{
			System.out.print( (1 + i) + ". " );
			chansons.get( i ).afficher();
		}
	}
}
