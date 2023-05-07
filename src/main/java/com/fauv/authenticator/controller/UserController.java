package com.fauv.authenticator.controller;

import java.security.Principal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fauv.authenticator.dto.UserDTO;
import com.fauv.authenticator.entity.User;
import com.fauv.authenticator.exception.AuthenticationException;
import com.fauv.authenticator.exception.RoleException;
import com.fauv.authenticator.exception.UserException;
import com.fauv.authenticator.form.EditUserForm;
import com.fauv.authenticator.form.UserForm;
import com.fauv.authenticator.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<UserDTO> create(@RequestBody UserForm form) throws AuthenticationException, UserException, RoleException{
		User createdUser = userService.create(form);
		
		UserDTO createdUserDTO = userService.to(createdUser);
		
		return ResponseEntity.ok(createdUserDTO);
	}
	
	@PutMapping
	public ResponseEntity<UserDTO> update(@RequestBody EditUserForm editUserForm) throws AuthenticationException, UserException, RoleException{		
		User updatedUser = userService.update(editUserForm);
		
		UserDTO updatedUserDTO = userService.to(updatedUser);
		
		return ResponseEntity.ok(updatedUserDTO);
	}
	
	@GetMapping
	public ResponseEntity<Set<UserDTO>> getAll() {
		Set<User> users = userService.getAll();
		
		return ResponseEntity.ok(userService.to(users));
	}
	
	@GetMapping("/whoAmI")
	public ResponseEntity<UserDTO> whoAmI(Principal principal){
		return ResponseEntity.ok(userService.whoAmI(principal.getName()));
	}

}

