package fr.lteconsulting.exception;

public class DAOException extends Exception
{
	public DAOException( String message )
	{
		this( message, null );
	}

	public DAOException( String message, Throwable throwable )
	{
		super( message, throwable );
	}
}
