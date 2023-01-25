package com.fauv.authenticator.utils;

import java.util.Date;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class JwtUtils {
		
	private String secret;
	private String issuer;
	private JWTVerifier jwtVerifier;
	
	public JwtUtils(String secret, String issuer) {
		this.secret = secret;
		this.issuer = issuer;
	}
		
	public String generate(Map<String, String> claims, String subject, int expireTime) {
		Date today = new Date();
		
	    Algorithm algorithm = Algorithm.HMAC512(this.secret);
		
		return JWT.create()
				.withIssuer(this.issuer)
				.withSubject(subject)
				.withPayload(claims)
				.withIssuedAt(today)
				.withExpiresAt(new Date(today.getTime()+expireTime))
				.sign(algorithm);
	}
	
	public Map<String, Claim> getClaims(String token) {
		DecodedJWT decodedJWT = getJWTVerifier().verify(token);
		
		return decodedJWT.getClaims();
	}
	
	public String getSubject(String token) {
		DecodedJWT decodedJWT = getJWTVerifier().verify(token);
		
		return decodedJWT.getSubject();
	}
	
	public boolean isTokenValid(String token) {
		try {
			getJWTVerifier().verify(token);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	private JWTVerifier getJWTVerifier() {
		if (this.jwtVerifier == null) { this.jwtVerifier = buildJWTVerifier(); }
		
		return this.jwtVerifier;
		
	}
	
	private JWTVerifier buildJWTVerifier() {
	    Algorithm algorithm = Algorithm.HMAC512(this.secret);
	    return JWT.require(algorithm).withIssuer(this.issuer).build();
	}
	
}
