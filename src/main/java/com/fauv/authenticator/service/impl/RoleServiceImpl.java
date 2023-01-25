package com.fauv.authenticator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fauv.authenticator.entity.Role;
import com.fauv.authenticator.exception.RoleException;
import com.fauv.authenticator.message.RoleMessage;
import com.fauv.authenticator.repository.RoleRepository;
import com.fauv.authenticator.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role getByName(String name) {
		return roleRepository.findByName(name);
	}

	@Override
	public Role getByNameAndValidateIt(String name) throws RoleException {
		Role role = getByName(name);
		
		if (role == null) { throw new RoleException(RoleMessage.NOT_FOUND); }
		
		return role;
	}

	@Override
	public Role getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
