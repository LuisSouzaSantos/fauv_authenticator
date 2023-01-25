package com.fauv.authenticator.service.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fauv.authenticator.dto.RoleDTO;
import com.fauv.authenticator.dto.UserDTO;
import com.fauv.authenticator.entity.Role;
import com.fauv.authenticator.entity.User;
import com.fauv.authenticator.exception.RoleException;
import com.fauv.authenticator.exception.UserException;
import com.fauv.authenticator.form.EditUserForm;
import com.fauv.authenticator.form.UserForm;
import com.fauv.authenticator.message.UserMessage;
import com.fauv.authenticator.repository.UserRepository;
import com.fauv.authenticator.service.RoleService;
import com.fauv.authenticator.service.UserService;
import com.fauv.authenticator.utils.PasswordUtils;
import com.fauv.authenticator.validator.UserValidator;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public User getByVwId(String vwId) {
		return userRepository.findById(vwId).orElse(null);
	}

	// TODO: Include VW_ID Validator
	@Override
	public User create(UserForm form) throws UserException, RoleException {
		userValidator.validateUserFormFields(form);
		
		User duplicateUser = getByVwId(form.getVwId());
		
		if (duplicateUser != null) { throw new UserException(UserMessage.ERROR_DUPLICATE); }
		if (!form.getPassword().equals(form.getPasswordConfirmation()))  { throw new UserException(UserMessage.ERROR_PASSWORD_CONFIRMATION); }
		
		Set<Role> validatedRoles = new HashSet<>();
		
		for (RoleDTO role : form.getRoles()) {
			Role validatedRole = roleService.getByNameAndValidateIt(role.getName());
			
			validatedRoles.add(validatedRole);
		}
		
		User user = new User();
		user.setVwId(form.getVwId());
		user.setPassword(PasswordUtils.hashPassword(form.getPassword()));
		user.setActive(false);
		user.setRoles(validatedRoles);
		
		return userRepository.save(user);
	}

	@Override
	public User update(EditUserForm form) throws UserException, RoleException {
		userValidator.validateEditUserFormFields(form);
		
		User editedUser = getByVwId(form.getVwId());
		
		if (form.tryingEditedPassword() && !form.getPassword().equals(form.getPasswordConfirmation()))  { throw new UserException(UserMessage.ERROR_PASSWORD_CONFIRMATION); }
		
		Set<Role> validatedRoles = new HashSet<>();
		
		for (RoleDTO role : form.getRoles()) {
			Role validatedRole = roleService.getByNameAndValidateIt(role.getName());
			
			validatedRoles.add(validatedRole);
		}
		
		if (form.tryingEditedPassword()) {
			editedUser.setPassword(PasswordUtils.hashPassword(form.getPassword()));
		}
		
		editedUser.setActive(form.isActive());
		editedUser.setRoles(validatedRoles);
		
		return editedUser;
	}

	@Override
	public UserDTO to(User user) {
		if (user == null) { return null; }
		
		return modelMapper.map(user, UserDTO.class);
	}

	@Override
	public Set<UserDTO> to(Set<User> users) {
		if (users == null) { return null; }
		
		Set<UserDTO> usersDTO = new HashSet<>();
		
		for (User user : users) {
			usersDTO.add(to(user));
		}
		
		return usersDTO;
	}

	@Override
	public User to(UserDTO user) {
		if (user == null) { return null; }
		
		return modelMapper.map(user, User.class);
	}

	@Override
	public Set<User> getAll() {
		return userRepository.findAll().stream().collect(Collectors.toSet());
	}
	
}
