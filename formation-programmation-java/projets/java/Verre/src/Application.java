
public class Application
{
	public static void main( String[] args )
	{
		Verre verre = new Verre( 50, 300 );

		int volumeVide = verre.vider( 25 );
		System.out.println( volumeVide + " cl sont tombés du verre" );

		volumeVide = verre.vider( 50 );
		System.out.println( volumeVide + " cl sont tombés du verre" );
	}

}
