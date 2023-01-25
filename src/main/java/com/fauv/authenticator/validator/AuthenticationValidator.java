package com.fauv.authenticator.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fauv.authenticator.exception.AuthenticationException;
import com.fauv.authenticator.form.AuthenticationForm;

@Service
public class AuthenticationValidator {

	@Autowired
	private Validator validator;
	
	public void validateAuthenticationFormFields(AuthenticationForm form) throws AuthenticationException {
		Set<ConstraintViolation<AuthenticationForm>> violations = validator.validate(form);
		
		if (violations.isEmpty()) { return; }
		
		throw new AuthenticationException("INCLUDE_NEW_RULE");
	}
	
}
