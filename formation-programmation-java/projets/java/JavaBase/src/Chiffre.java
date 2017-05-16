
public class Chiffre
{
	public static void main( String[] args )
	{
		String clair = "Bonjour mon général";

		String chiffre = decale( clair, 10 );

		System.out.println( chiffre );

		System.out.println( decale( chiffre, -10 ) );
	}

	static String decale( String message, int decalage )
	{
		// String -> char[]
		char[] caracteres = message.toCharArray();

		// coder chaque char
		for( int i = 0; i < caracteres.length; i++ )
			caracteres[i] = (char) ((caracteres[i] + decalage) % 256);

		// char[] -> String
		return String.valueOf( caracteres );
	}
}
