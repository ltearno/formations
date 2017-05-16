
public class Tableau1
{
	public static void main( String[] args )
	{
		long[] t = new long[13];

		remplirTableau( t );

		lireTableau( t );
	}

	static void lireTableau( long[] tableau )
	{
		for( int i = 0; i < tableau.length; i++ )
			System.out.println( i + ": " + tableau[i] );
	}

	static void remplirTableau( long[] leTableau )
	{
		for( int i = 0; i < leTableau.length; i++ )
			leTableau[i] = 2 * i;
	}
}
