package fr.lteconsulting;

public class Tokenizer
{
	private String string;
	private int index;

	public Tokenizer( String string )
	{
		this.string = string;
	}

	public String getNextToken()
	{
		if( index >= string.length() )
			return null;

		skipSpaces();

		String token;

		int nextSpace = string.indexOf( ' ', index );
		if( nextSpace >= 0 )
		{
			token = string.substring( index, nextSpace );
			index = nextSpace;
		}
		else
		{
			token = string.substring( index );
			index = string.length();
		}

		return token;
	}

	private void skipSpaces()
	{
		while( string.charAt( index ) == ' ' )
			index++;
	}
}
