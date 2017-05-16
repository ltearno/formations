
public class AireRectangle
{
	public static void main( String[] args )
	{
		// aire du rectangle de dimension 120 x 235
		System.out.println( "L'aire du rectangle est " + aire( 120, 235 ) );
	}

	static int aire( int largeur, int longueur )
	{
		return largeur * longueur;
	}
}
