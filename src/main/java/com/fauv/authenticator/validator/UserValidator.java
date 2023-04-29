package com.fauv.authenticator.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fauv.authenticator.exception.UserException;
import com.fauv.authenticator.form.EditUserForm;
import com.fauv.authenticator.form.RegisterForm;
import com.fauv.authenticator.form.UserForm;
import com.fauv.authenticator.message.UserMessage;

@Service
public class UserValidator {

	@Autowired
	private Validator validator;
	
	public void validateUserFormFields(UserForm form) throws UserException {
		Set<ConstraintViolation<UserForm>> violations = validator.validate(form);
		
		if (!violations.isEmpty()) { throw new UserException(violations.toString()); }
		
		if (form.getRoles() == null || form.getRoles().isEmpty()) { throw new UserException(UserMessage.ROLES_FORM); }
	}

	public void validateRegisterFormFields(RegisterForm form) throws UserException {
		Set<ConstraintViolation<RegisterForm>> violations = validator.validate(form);
		
		if (!violations.isEmpty()) { throw new UserException(violations.toString()); }
		
		if (form.getRoles() == null || form.getRoles().isEmpty()) { throw new UserException(UserMessage.ROLES_FORM); }
	}
	
	public void validateEditUserFormFields(EditUserForm form) throws UserException {
		Set<ConstraintViolation<EditUserForm>> violations = validator.validate(form);
		
		if (!violations.isEmpty()) { throw new UserException(violations.toString()); }
		
		if (form.getRoles() == null || form.getRoles().isEmpty()) { throw new UserException(UserMessage.ROLES_FORM); }
	}
	
	
}
