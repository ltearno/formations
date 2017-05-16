
public class Somme
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
		int resultat = 0;
		
		for( int i = 0; i <= n; i++ )
			resultat += i;
		
		return resultat;
	}
}
