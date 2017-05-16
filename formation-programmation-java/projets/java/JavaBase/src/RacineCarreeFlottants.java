
public class RacineCarreeFlottants
{
	public static void main( String[] args )
	{
		for( int i = 1; i < 100; i++ )
		{
			for( int nbIterations = 1; nbIterations < 10; nbIterations++ )
				System.out.println( "SQRT(" + i + ") = " + racineCarree( i, nbIterations ) + " avec " + nbIterations + " itérations" );
		}
	}

	static double approche( double v, double approximation )
	{
		return (approximation + v / approximation) / 2;
	}

	static double racineCarree( double v, int nbIterations )
	{
		double approximation = v / 2;

		for( int i = 0; i < nbIterations; i++ )
		{
			double nouvelleApproximation = approche( v, approximation );
			if( nouvelleApproximation == approximation )
				return approximation;

			approximation = nouvelleApproximation;
		}

		return approximation;
	}
}
