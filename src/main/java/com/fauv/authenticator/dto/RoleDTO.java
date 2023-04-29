package com.fauv.authenticator.dto;

public class RoleDTO {

	// administrator / inspector / consultant
	private String name;
	private boolean admin = false;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isAdmin() {
		return admin;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
}
