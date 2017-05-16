public class TestException
{
	public static void main( String[] args )
	{
		try
		{
			String argument = args[0];

			int n = Integer.parseInt( argument );

			factorielle( n );
		}
		catch( ArrayIndexOutOfBoundsException e )
		{
			System.out.println( "Indiquez le nombre d'entiers sur la ligne de commande" );
		}
		catch( NumberFormatException e )
		{
			System.out.println( "L'argument doit être entier" );
		}
		catch( ExceptionNegatif e )
		{
			System.out.println( e + " : la factorielle n'est pas définie" );
		}
		catch( ExceptionGrand e )
		{
			System.out.println( "ExceptionGrand: " + e.getMessage() );
		}
	}

	static int factorielle( int n ) throws ExceptionNegatif, ExceptionGrand
	{
		if( n < 0 )
			throw new ExceptionNegatif( n );

		if( n >= 14 )
			throw new ExceptionGrand( n + " est trop grand pour ce programme" );

		int result = 1;
		while( n-- > 1 )
			result *= n;
		return result;
	}
}
