package com.fauv.authenticator.dto;

import java.util.HashSet;
import java.util.Set;

public class UserDTO {

	private String vwId;
	private boolean active;
	private Set<RoleDTO> roles = new HashSet<RoleDTO>();
	
	public String getVwId() {
		return vwId;
	}
	
	public void setVwId(String vwId) {
		this.vwId = vwId;
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
