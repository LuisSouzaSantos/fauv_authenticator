package com.fauv.authenticator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fauv.authenticator.dto.AuthenticationDTO;
import com.fauv.authenticator.entity.User;
import com.fauv.authenticator.exception.AuthenticationException;
import com.fauv.authenticator.exception.TokenException;
import com.fauv.authenticator.form.AuthenticationForm;
import com.fauv.authenticator.message.AuthenticationMessage;
import com.fauv.authenticator.service.AuthenticationService;
import com.fauv.authenticator.service.TokenService;
import com.fauv.authenticator.service.UserService;
import com.fauv.authenticator.utils.PasswordUtils;
import com.fauv.authenticator.validator.AuthenticationValidator;

@Service
public class AuthenticationServiceImpl implements UserDetailsService, AuthenticationService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private AuthenticationValidator authenticationValidator;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getByVwId(username);
		
		if (user == null) { throw new UsernameNotFoundException(AuthenticationMessage.USER_NOT_FOUND_ON_SYSTEM); }
		
		return user;
	}

	@Override
	public void authenticateOnServer(UserDetails userDetails) {
		User user = userService.getByVwId(userDetails.getUsername());
		
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
	}

	@Override
	public AuthenticationDTO authentication(AuthenticationForm form) throws AuthenticationException, TokenException {
		authenticationValidator.validateAuthenticationFormFields(form);
		
		User user = userService.getByVwId(form.getVwId());
				
		if (user == null) { throw new AuthenticationException(AuthenticationMessage.USER_NOT_FOUND_ON_SYSTEM); }
		
		if (!user.isActive()) { throw new AuthenticationException(AuthenticationMessage.USER_INACTIVE); }
		
		if (!PasswordUtils.validateHashWithPassword(form.getPassword(), user.getPassword())) { throw new AuthenticationException(AuthenticationMessage.USER_WRONG_PASSWORD); }
		
		AuthenticationDTO authenticationDTO = new AuthenticationDTO();
		authenticationDTO.setToken(tokenService.generate(user));
		
		return authenticationDTO;
	}

}
