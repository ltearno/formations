package fr.lteconsulting.formation.generiques;

import java.util.Comparator;

/**
 * Cette classe permet de trier un tableau d'objets
 */
public class Sorter<T>
{
	private Comparator<T> comparator;

	public Sorter( Comparator<T> comparator )
	{
		this.comparator = comparator;
	}

	public T[] trier( T[] tableau )
	{
		if( tableau.length <= 1 )
			return tableau;

		// couper tableau en deux
		int indexMoitie = tableau.length / 2;

		T[] moitieUn = extraire( tableau, 0, indexMoitie );
		T[] moitieDeux = extraire( tableau, indexMoitie, tableau.length );

		// trier chaque moitie
		moitieUn = trier( moitieUn );
		moitieDeux = trier( moitieDeux );

		// raseembler les deux moitié
		return rassembler( moitieUn, moitieDeux );
	}

	private T[] rassembler( T[] moitieUn, T[] moitieDeux )
	{
		int i1 = 0;
		int i2 = 0;

		T[] resultat = (T[]) new Object[moitieUn.length + moitieDeux.length];

		for( int iR = 0; iR < resultat.length; iR++ )
		{
			if( i2 == moitieDeux.length
					|| (i1 < moitieUn.length
							&& (comparator.compare( moitieUn[i1], moitieDeux[i2] ) < 0)) )
			{
				resultat[iR] = moitieUn[i1++];
			}
			else
			{
				resultat[iR] = moitieDeux[i2++];
			}
		}

		return resultat;
	}

	private T[] extraire( T[] tableau, int debut, int fin )
	{
		int taille = fin - debut;
		T[] resultat = (T[]) new Object[taille];

		for( int i = 0; i < taille; i++ )
			resultat[i] = tableau[i + debut];

		return resultat;
	}
}
