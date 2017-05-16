package fr.lteconsulting;

import java.io.Serializable;

public class Piece implements Serializable
{
	private static final long serialVersionUID = 8008218646023686814L;

	private char displayChar;

	public Piece( char displayChar )
	{
		this.displayChar = displayChar;
	}

	public char getDisplayChar()
	{
		return displayChar;
	}
}
