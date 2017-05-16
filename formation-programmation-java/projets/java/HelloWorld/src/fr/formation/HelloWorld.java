package fr.formation;

public class HelloWorld
{
	static int jeterUnDe()
	{
		return jeterUnDe( 6 );
	}
	
	static int jeterUnDe( int nombreDeFaces )
	{
		double d = Math.random();
		d *= nombreDeFaces;
		int n = (int) d;
		n = n + 1;
		
		return n;
	}
	
	public static void main( String[] args )
	{
		for( int i = 0; i < 10; i++ )
		{
			int valeurDuDe = jeterUnDe( 12 );

			System.out.println( "Tirage " + i + " = " + valeurDuDe );
		}
	}
}
