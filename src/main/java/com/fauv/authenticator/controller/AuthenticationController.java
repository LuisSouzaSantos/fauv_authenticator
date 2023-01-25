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

import com.fauv.authenticator.dto.AuthenticationDTO;
import com.fauv.authenticator.entity.PathAuthentication;
import com.fauv.authenticator.exception.AuthenticationException;
import com.fauv.authenticator.exception.TokenException;
import com.fauv.authenticator.form.AuthenticationForm;
import com.fauv.authenticator.security.enums.PathAuthenticationType;
import com.fauv.authenticator.service.AuthenticationService;


@CrossOrigin
@RestController
@RequestMapping("/accessControl")
public class AuthenticationController {

	public final static List<PathAuthentication> APIS_GET = Arrays.asList();
	public final static List<PathAuthentication> APIS_POST = Arrays.asList(new PathAuthentication("/accessControl/login", PathAuthenticationType.NO_AUTHENTICATION_NEEDED));
	public final static List<PathAuthentication> APIS_PUT = Arrays.asList();
	public final static List<PathAuthentication> APIS_DELETE = Arrays.asList();
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping("/login")
	public ResponseEntity<AuthenticationDTO> authentication(@RequestBody AuthenticationForm form) throws AuthenticationException, TokenException{
		return ResponseEntity.ok(authenticationService.authentication(form));
	}
	
}
