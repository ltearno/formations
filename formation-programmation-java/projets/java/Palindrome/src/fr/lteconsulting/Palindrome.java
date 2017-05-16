package fr.lteconsulting;

public class Palindrome
{
	static boolean estPalindrome( String s )
	{
		int jccc = 0;
		for( int i = 0; i < s.length() / 2; i++ )
		{
			if( s.charAt( i ) != s.charAt( s.length() - i - 1 ) )
				return false;
		}
		
		int j = jccc;

		return true;
	}

	public static void main( String[] args )
	{
		for( String s : args )
		{
			System.out.println( s + " ? " + estPalindrome( s ) );
		}
	}
}
