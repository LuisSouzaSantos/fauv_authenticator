package com.fauv.authenticator.service;

import com.fauv.authenticator.entity.User;
import com.fauv.authenticator.exception.TokenException;

public interface TokenService {
	
	public String generate(User user) throws TokenException;
	
	public boolean isValid(String token);
	
	public String getUsername(String token);
	
}
