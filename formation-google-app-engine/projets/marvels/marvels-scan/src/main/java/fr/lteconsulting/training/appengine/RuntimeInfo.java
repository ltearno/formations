package fr.lteconsulting.training.appengine;

public class RuntimeInfo
{

	public static String getInfo()
	{
		return "Version: " + System.getProperty( "java.version" )
				+ " OS: " + System.getProperty( "os.name" )
				+ " User: " + System.getProperty( "user.name" );
	}
}