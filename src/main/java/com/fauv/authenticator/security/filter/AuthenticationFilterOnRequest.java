package com.fauv.authenticator.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fauv.authenticator.service.AuthenticationService;
import com.fauv.authenticator.service.TokenService;

public class AuthenticationFilterOnRequest extends OncePerRequestFilter {

	private static final String AUTHORIZATION_HEADER = "Authorization";
	
	private AuthenticationService authenticationService;
	private TokenService tokenService;
	
	public AuthenticationFilterOnRequest(AuthenticationService authenticationService, TokenService tokenService) {
		this.authenticationService = authenticationService;
		this.tokenService = tokenService;
	}
	
	@Transactional
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String token = request.getHeader(AUTHORIZATION_HEADER);
		
		if (tokenService.isValid(token)) { tryingToAuthenticateTheUserOnServer(token); }
		
		filterChain.doFilter(request, response);
	}

	private void tryingToAuthenticateTheUserOnServer(String token) {
		String username = tokenService.getUsername(token);
		
		UserDetails user = authenticationService.loadUserByUsername(username);
		
		authenticationService.authenticateOnServer(user);
	}
	
	
}
