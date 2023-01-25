package com.fauv.authenticator.service;

import com.fauv.authenticator.entity.Role;
import com.fauv.authenticator.exception.RoleException;

public interface RoleService {

	public Role getByName(String name);
	
	public Role getByNameAndValidateIt(String name) throws RoleException;
	
	public Role getAll();
	
}
