package com.fauv.authenticator.form;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fauv.authenticator.message.UserMessage;

public class RegisterForm {

	@NotBlank(message = UserMessage.VW_ID_FORM)
	@Size(min = 7, max = 10, message = UserMessage.VW_ID_FORM_SIZE)
	private String vwId;
	@NotBlank(message = UserMessage.PASSWORD_FORM)
	private String password;
	@NotBlank(message = UserMessage.PASSWORD_CONFIRMATION_FORM)
	private String passwordConfirmation;
	private Set<String> roles = new HashSet<String>();
	
	public String getVwId() {
		return vwId;
	}
	
	public void setVwId(String vwId) {
		this.vwId = vwId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	
	

}
