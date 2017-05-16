
public class RacineCarreeEntiers
{
	public static void main( String[] args )
	{
		for( int i = 1; i <= 1000; i++ )
		{
			System.out.println( "La racine carrée de " + i + " vaut " + racineCarree( i ) );
		}
	}

	static int racineCarree( int n )
	{
		for( int i = 1; i < n; i++ )
		{
			// on calcule le carré de i
			int test = i * i;

			// si on tombe juste, i est la racine carrée de n
			if( test == n )
				return i;

			// si on est au dessus, la racine carrée est i - 1
			if( test > n )
				return i - 1;
		}

		return 0;
	}
}
