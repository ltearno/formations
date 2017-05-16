
public class SommeRecursive
{
	public static void main( String[] args )
	{
		for( int i = 1; i <= 1000; i++ )
		{
			System.out.println( "La somme des " + i + " premiers entiers vaut " + somme( i ) );
		}
	}

	static int somme( int n )
	{
		if( n == 0 )
			return 0;

		return n + somme( n - 1 );
	}
}
