package fr.lteconsulting;

import java.util.Random;

import fr.lteconsulting.modele.Chanson;
import fr.lteconsulting.modele.Disque;
import fr.lteconsulting.outils.Mots;

public class GenerateurDisque
{
	public Disque genererDisque()
	{
		Disque disque = new Disque( Mots.phrase() );

		int nbChansons = 3 + new Random().nextInt( 10 );

		while( nbChansons-- > 0 )
			disque.addChanson( creerChanson() );

		return disque;
	}

	private Chanson creerChanson()
	{
		return new Chanson( Mots.phrase(), 30 + new Random().nextInt( 60 ) );
	}
}
