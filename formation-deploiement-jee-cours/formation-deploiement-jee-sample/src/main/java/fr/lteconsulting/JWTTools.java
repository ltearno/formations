package fr.lteconsulting;

import java.util.HashMap;
import java.util.Map;

public class JWTTools {
	private final static ThreadLocal<Map<String, Object>> currentClaims = new ThreadLocal<>();

	public static Map<String, Object> getClaims() {
		return currentClaims.get();
	}

	@SuppressWarnings("unchecked")
	public static <T> T get(String key) {
		Map<String, Object> claims = currentClaims.get();
		return claims != null ? (T) claims.get(key) : null;
	}

	public static void put(String key, Object value) {
		Map<String, Object> claims = currentClaims.get();
		if (claims == null) {
			claims = new HashMap<>();
			currentClaims.set(claims);
		}

		claims.put(key, value);
	}

	static void setClaims(Map<String, Object> claims) {
		currentClaims.set(claims);
	}
}
