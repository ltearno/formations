package fr.lteconsulting;

import java.io.IOException;
import java.security.Key;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

public class JWTFilter implements Filter {
	static Key key = createKey();

	private final static ThreadLocal<Integer> currentClaimsHashCode = new ThreadLocal<>();

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (request instanceof HttpServletRequest) {
			String jwtPayload = Tools.getCookie((HttpServletRequest) request, "JJWTID");
			if (jwtPayload != null) {
				try {
					Jws<Claims> claims = Jwts.parser().setSigningKey(key).parseClaimsJws(jwtPayload);

					JWTTools.setClaims(claims.getBody());
					currentClaimsHashCode.set(claims.getBody().hashCode());
				} catch (SignatureException e) {
				}
			}
		}

		chain.doFilter(request, response);

		if (response instanceof HttpServletResponse) {
			Map<String, Object> claims = JWTTools.getClaims();
			Integer currentHashCode = claims != null ? claims.hashCode() : 0;
			if (!currentHashCode.equals(currentClaimsHashCode.get())) {
				String payload = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, key).compact();
				((HttpServletResponse) response).addCookie(new Cookie("JJWTID", payload));
			}

			JWTTools.setClaims(null);
			currentClaimsHashCode.set(null);
		}
	}

	@Override
	public void destroy() {
	}

	private static Key createKey() {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		byte[] apiKeySecretBytes = "alja lkejhe kjhdaoiuha oisjlkaj shakhs ius hlajka sjaskhas jhskjhadg kjagy aufygfakhfkjhg"
				.getBytes();

		Key key = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		return key;
	}
}
