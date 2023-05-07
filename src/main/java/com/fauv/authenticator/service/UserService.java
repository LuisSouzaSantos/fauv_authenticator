package com.fauv.authenticator.service;

import java.util.Set;

import com.fauv.authenticator.dto.UserDTO;
import com.fauv.authenticator.entity.User;
import com.fauv.authenticator.exception.RoleException;
import com.fauv.authenticator.exception.UserException;
import com.fauv.authenticator.form.EditUserForm;
import com.fauv.authenticator.form.RegisterForm;
import com.fauv.authenticator.form.UserForm;

public interface UserService {

	public User getByVwId(String vwId);
	
	public User create(UserForm form) throws UserException, RoleException;
	
	public void registerUser(RegisterForm registerForm) throws UserException, RoleException;
	
	public User update(EditUserForm form) throws UserException, RoleException;
	
	public UserDTO to(User user);
	
	public Set<UserDTO> to(Set<User> users);
	
	public User to(UserDTO user);
	
	public Set<User> getAll();
	
	public UserDTO whoAmI(String vwId);
	
}
