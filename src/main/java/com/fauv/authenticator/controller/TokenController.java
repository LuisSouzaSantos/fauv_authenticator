package com.fauv.authenticator.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fauv.authenticator.dto.TokenValidationRequest;
import com.fauv.authenticator.dto.TokenValidationResponse;
import com.fauv.authenticator.entity.PathAuthentication;
import com.fauv.authenticator.security.enums.PathAuthenticationType;
import com.fauv.authenticator.service.TokenService;

@CrossOrigin("*")
@RestController
@RequestMapping("/token")
public class TokenController {

	public final static List<PathAuthentication> APIS_GET = Arrays.asList();
	public final static List<PathAuthentication> APIS_POST = 
			Arrays.asList(new PathAuthentication("/token/validate", PathAuthenticationType.NO_AUTHENTICATION_NEEDED));
	public final static List<PathAuthentication> APIS_PUT = Arrays.asList();
	public final static List<PathAuthentication> APIS_DELETE = Arrays.asList();
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/validate")
	public ResponseEntity<TokenValidationResponse> validateToken(@RequestBody TokenValidationRequest tokenValidationRequest) {
		return ResponseEntity.ok(tokenService.validateCurrentToken(tokenValidationRequest));
	}
	
}
