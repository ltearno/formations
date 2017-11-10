package fr.lteconsulting;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

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
