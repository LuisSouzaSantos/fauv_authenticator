package com.fauv.authenticator.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fauv.authenticator.configuration.Properties;
import com.fauv.authenticator.dto.TokenValidationRequest;
import com.fauv.authenticator.dto.TokenValidationResponse;
import com.fauv.authenticator.entity.User;
import com.fauv.authenticator.exception.TokenException;
import com.fauv.authenticator.message.TokenMessage;
import com.fauv.authenticator.service.TokenService;
import com.fauv.authenticator.utils.JwtUtils;
import com.fauv.authenticator.utils.Utils;

@Service
public class TokenServiceImpl implements TokenService  {

	private static JwtUtils jwtUtils = null;
	
	@Autowired
	private Properties properties;
	
	@Override
	public String generate(User user) throws TokenException {
		if (user == null) { throw new TokenException(TokenMessage.NOT_POSSIBLE_GENERATE_TOKEN_TO_USER_NULL); }
		if (!user.isActive()) { throw new TokenException(TokenMessage.NOT_POSSIBLE_GENERATE_TOKEN_TO_INACTIVE_USER); }
		
		Map<String, String> claims = new HashMap<>();
		try {
			claims.put("current_roles", Utils.objectMapper.writeValueAsString(user.getRoles()));
		} catch (JsonProcessingException e) {
			claims.put("current_roles", null);
		}
		
		return getJwtUtils().generate(claims, user.getVwId(), properties.getJwtExpiration());
	}

	@Override
	public boolean isValid(String token) {
		return getJwtUtils().isTokenValid(token);
	}

	@Override
	public String getUsername(String token) {
		return getJwtUtils().getSubject(token);
	}
	
	@Override
	public TokenValidationResponse validateCurrentToken(TokenValidationRequest tokenValidationRequest) {
		TokenValidationResponse tokenValidation = new TokenValidationResponse();
				
		tokenValidation.setValid(tokenValidation != null ? isValid(tokenValidationRequest.getValue()): false);
		
		return tokenValidation;
	}
	
	private JwtUtils getJwtUtils() {
		if (jwtUtils == null) { jwtUtils = new JwtUtils(properties.getJwtSecret(), "FAUV_AUTHENTITOR"); }
		
		return jwtUtils;
	}

}