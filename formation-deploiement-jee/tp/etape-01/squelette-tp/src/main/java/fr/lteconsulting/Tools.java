package fr.lteconsulting;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/*
    Utilisez cette classe à votre convenance, vous pouvez même la supprimer !
*/
public class Tools {
    public static String getCookie(HttpServletRequest request, String cookieName) {
		if (cookieName == null)
			return null;

		Cookie[] cookies = request.getCookies();
		if (cookies == null)
			return null;

		for (int i = 0; i < cookies.length; i++)
			if (cookieName.equals(cookies[i].getName()))
				return cookies[i].getValue();

		return null;
	}
}
