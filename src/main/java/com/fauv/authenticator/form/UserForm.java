package com.fauv.authenticator.form;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.fauv.authenticator.dto.RoleDTO;
import com.fauv.authenticator.message.UserMessage;

public class UserForm {

	@NotBlank(message = UserMessage.VW_ID_FORM)
	private String vwId;
	@NotBlank(message = UserMessage.PASSWORD_FORM)
	private String password;
	@NotBlank(message = UserMessage.PASSWORD_CONFIRMATION_FORM)
	private String passwordConfirmation;
	private boolean active = false;
	private Set<RoleDTO> roles = new HashSet<RoleDTO>();
	
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
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleDTO> roles) {
		this.roles = roles;
	}
		
}
