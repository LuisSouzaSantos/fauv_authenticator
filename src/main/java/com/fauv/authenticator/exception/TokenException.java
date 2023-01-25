package com.fauv.authenticator.exception;

import org.springframework.http.HttpStatus;

public class TokenException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public TokenException(String message) {
		super(message);
		this.setStatus(HttpStatus.UNAUTHORIZED);
	}
	
}
