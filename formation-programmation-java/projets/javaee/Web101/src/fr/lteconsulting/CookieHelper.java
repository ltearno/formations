package fr.lteconsulting;

import javax.servlet.http.Cookie;

public class CookieHelper
{
	public static Cookie getCookie( Cookie[] cookies, String name )
	{
		if( cookies != null )
		{
			for( Cookie cookie : cookies )
			{
				if( cookie.getName().equals( name ) )
					return cookie;
			}
		}
		
		return null;
	}
}
