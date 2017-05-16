package fr.lteconsulting;

public class Tri
{
	public static void main( String[] args )
	{
		for( int i = 0; i < 500; i++ )
		{
			int[] tableauAleatoire = genereTableau();
			printTableau( tableauAleatoire );
			if( estTrie( tableauAleatoire ) )
				System.out.println( "VA JOUER AU LOTO" );

			int[] tableauTrie = trier( tableauAleatoire );
			printTableau( tableauTrie );

			boolean ok = estTrie( tableauTrie );
			if( !ok )
				System.out.println( "GROS BUG" );

			System.out.println();
		}
	}

	static boolean estTrie( int[] tableau )
	{
		int valeurPrecedente = Integer.MIN_VALUE;

		for( int valeur : tableau )
		{
			if( valeur < valeurPrecedente )
				return false;

			valeurPrecedente = valeur;
		}

		return true;
	}

	static int[] genereTableau()
	{
		int taille = genereNombre( 20 );
		int[] resultat = new int[taille];

		for( int i = 0; i < taille; i++ )
			resultat[i] = genereNombre( 100 );

		return resultat;
	}

	static int genereNombre( int limite )
	{
		return 1 + (int) (Math.random() * limite);
	}

	/**
	 * Tri le tableau en paramètre et retourne une copie triée du tableau
	 * 
	 * @param tableau Le tableau à trier
	 * @return Le tableau trié
	 */
	static int[] trier( int[] tableau )
	{
		// cas terminal
		if( tableau.length <= 1 )
			return tableau;

		// découper tableau en deux
		int indiceMedian = tableau.length / 2;
		int[] tA = sousTableau( tableau, 0, indiceMedian );
		int[] tB = sousTableau( tableau, indiceMedian, tableau.length );

		// trier chaque tableau
		tA = trier( tA );
		tB = trier( tB );

		// combiner le resultat
		int[] resultat = combiner( tA, tB );

		return resultat;
	}

	static void printTableau( int[] tableau )
	{
		System.out.print( "[" );
		boolean addComa = false;

		for( int valeur : tableau )
		{
			if( addComa )
				System.out.print( "," );
			else
				addComa = true;
			System.out.print( String.valueOf( valeur ) );
		}
		System.out.println( "]" );
	}

	/**
	 * Retourne un tableau trié, résultat de la combinaison entre les deux
	 * tableaux passés en paramètre (qui doivent être triés aussi)
	 * 
	 * @param tA un tableau trié
	 * @param tB un tableau trié
	 * @return un tableau trié
	 */
	static int[] combiner( int[] tA, int[] tB )
	{
		int tailleResultat = tA.length + tB.length;
		int[] resultat = new int[tailleResultat];

		int iA = 0;
		int iB = 0;
		int iR = 0;

		while( iR < tailleResultat )
		{
			if( iB >= tB.length || (iA < tA.length && tA[iA] < tB[iB]) )
			{
				resultat[iR] = tA[iA];
				iA++;
				iR++;
			}
			else
			{
				resultat[iR] = tB[iB];
				iB++;
				iR++;
			}
		}

		return resultat;
	}

	/**
	 * Retourne une partie du tableau passé en paramètre.
	 * 
	 * La partie retournée contient les cellules debut à fin (exclu) du tableau passé en paramètre
	 * 
	 * @param tableau Le tableau à découper
	 * @param debut L'indice de la premiere cellule à copier
	 * @param fin
	 * @return Un tableau contenant ...
	 */
	static int[] sousTableau( int[] tableau, int debut, int fin )
	{
		int[] resultat = new int[fin - debut];
		for( int i = debut; i < fin; i++ )
			resultat[i - debut] = tableau[i];
		return resultat;
	}
}
