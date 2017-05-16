
public class TriNaif
{
	public static void main( String[] args )
	{
		int[] t = new int[] { 23, 6, 14, 8, 1, 19, 34, 20 };

		afficherTableau( t );

		trier( t );

		afficherTableau( t );
	}

	static void afficherTableau( int[] tableau )
	{
		System.out.println( "CONTENU DU TABLEAU" );
		for( int i = 0; i < tableau.length; i++ )
			System.out.println( i + ": " + tableau[i] );
	}

	static void trier( int[] tableau )
	{
		for( int i = 0; i < tableau.length; i++ )
		{
			int indexMin = indexCelluleMin( tableau, i );
			echange( tableau, i, indexMin );
		}
	}

	static void echange( int[] t, int indiceA, int indiceB )
	{
		int dummy = t[indiceA];
		t[indiceA] = t[indiceB];
		t[indiceB] = dummy;
	}

	static int indexCelluleMin( int[] t, int indexDebutRecherche )
	{
		int iMin = indexDebutRecherche;

		for( int i = indexDebutRecherche + 1; i < t.length; i++ )
		{
			if( t[i] < t[iMin] )
				iMin = i;
		}

		return iMin;
	}
}
