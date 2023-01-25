package com.fauv.authenticator.exception;

import org.springframework.http.HttpStatus;

public class AuthenticationException extends BusinessException {

	private static final long serialVersionUID = 1L;
	
	public AuthenticationException(String message) {
		super(message);
		this.setStatus(HttpStatus.UNAUTHORIZED);
	}

}
