package com.fauv.authenticator.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fauv.authenticator.dto.AuthenticationDTO;
import com.fauv.authenticator.exception.AuthenticationException;
import com.fauv.authenticator.exception.TokenException;
import com.fauv.authenticator.form.AuthenticationForm;

public interface AuthenticationService {

	public AuthenticationDTO authentication(AuthenticationForm form) throws AuthenticationException, TokenException;
	
	public void authenticateOnServer(UserDetails userDetails);
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
