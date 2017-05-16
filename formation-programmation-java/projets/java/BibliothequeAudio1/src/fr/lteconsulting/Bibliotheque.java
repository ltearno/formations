package fr.lteconsulting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bibliotheque
{
	private Map<String, Disque> disques;

	public Bibliotheque()
	{
		disques = new HashMap<>();
	}

	public void ajouterDisque( Disque disque ) throws DisqueDejaPresentException
	{
		if( disques.containsKey( disque.getCodeBarre() ) )
			throw new DisqueDejaPresentException();

		disques.put( disque.getCodeBarre(), disque );

		disque.registerObserver( new IObserver<Disque>()
		{
			String ancienCodeBarre = disque.getCodeBarre();

			@Override
			public void onChange( Disque object )
			{
				System.out.println( "#### MISE A JOUR DES INDEX DE LA BIBLIOTHEQUE ####" );
				if( disques.containsKey( disque.getCodeBarre() ) )
					throw new RuntimeException( new DisqueDejaPresentException() );

				disques.remove( ancienCodeBarre );
				disques.put( disque.getCodeBarre(), disque );

				ancienCodeBarre = disque.getCodeBarre();
			}
		} );
	}

	public Collection<Disque> getDisques()
	{
		return disques.values();
	}

	public boolean retirerDisque( String codeBarre )
	{
		return disques.remove( codeBarre ) != null;
	}

	public int getNbDisques()
	{
		return disques.values().size();
	}

	public Disque getDisque( String codeBarre )
	{
		return disques.get( codeBarre );
	}

	public List<Disque> rechercherDisques( String recherche )
	{
		recherche = recherche.toLowerCase();

		List<Disque> result = new ArrayList<>();

		for( Disque disque : disques.values() )
		{
			if( disque.getNom().toLowerCase().contains( recherche ) )
				result.add( disque );
		}

		return result;
	}

	public List<Chanson> rechercherChansons( String recherche )
	{
		recherche = recherche.toLowerCase();

		List<Chanson> result = new ArrayList<>();

		for( Disque disque : disques.values() )
		{
			for( Chanson chanson : disque.getChansons() )
			{
				if( chanson.getNom().toLowerCase().contains( recherche ) )
					result.add( chanson );
			}
		}

		return result;
	}

	public void afficher()
	{
		System.out.println( "\nContenu de la bibliothèque" );

		for( Disque disque : disques.values() )
		{
			System.out.println();
			disque.afficher();
		}
	}
}
