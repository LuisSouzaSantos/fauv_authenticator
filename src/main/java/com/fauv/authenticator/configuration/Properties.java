package com.fauv.authenticator.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Properties {

	private String jwtSecret;
	private int jwtExpiration;
	
	public Properties(
			@Value("${application.jwt.secret}") String jwtSecret, 
			@Value("${application.jwt.expiration}") int jwtExpiration) {
		this.setJwtSecret(jwtSecret);
		this.setJwtExpiration(jwtExpiration);
	}

	public String getJwtSecret() {
		return jwtSecret;
	}

	public void setJwtSecret(String jwtSecret) {
		this.jwtSecret = jwtSecret;
	}

	public int getJwtExpiration() {
		return jwtExpiration;
	}

	public void setJwtExpiration(int jwtExpiration) {
		this.jwtExpiration = jwtExpiration;
	}

}
