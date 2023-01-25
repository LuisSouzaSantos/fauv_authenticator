package com.fauv.authenticator.form;

import javax.validation.constraints.NotBlank;

import com.fauv.authenticator.message.AuthenticationMessage;

public class AuthenticationForm {

	@NotBlank(message = AuthenticationMessage.AUTHENTICATION_FORM_VW_ID_ERROR)
	private String vwId;
	@NotBlank(message = AuthenticationMessage.AUTHENTICATION_FORM_PASSWORD_ERROR)
	private String password;
	
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
	
	
	
}
