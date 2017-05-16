package fr.lteconsulting.training.appengine.marvels.tools;

import java.security.MessageDigest;

public class MD5Tools
{
	public static String md5( String input )
	{
		if( input == null )
			return null;

		try
		{
			byte[] bytes = input.getBytes( "UTF-8" );

			MessageDigest md = MessageDigest.getInstance( "MD5" );
			byte[] digest = md.digest( bytes );

			StringBuilder builder = new StringBuilder();
			for( byte b : digest )
			{
				String part = Integer.toHexString( b & 0xff );
				if( part.length() == 1 )
					part = "0" + part;

				builder.append( part );
			}

			return builder.toString();
		}
		catch( Exception e )
		{
			return null;
		}
	}
}
