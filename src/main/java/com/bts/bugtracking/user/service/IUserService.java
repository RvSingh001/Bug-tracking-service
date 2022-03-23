package com.bts.bugtracking.user.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.bts.bugtracking.bug.model.Bug;
import com.bts.bugtracking.user.shared.OperationStatusModel;
import com.bts.bugtracking.user.wrapper.UserDetailsWrapper;
import com.bts.bugtracking.user.wrapper.UserResponseWrapper;

public interface IUserService  extends UserDetailsService {
	public UserResponseWrapper getUser(String id);

	public UserResponseWrapper createUser(UserDetailsWrapper userDetailsWrapper);

	public UserResponseWrapper updateUser(String id, UserDetailsWrapper userDetailsWrapper);

	public List<UserResponseWrapper> getAllUsers();

	public OperationStatusModel deleteUser(String id);

	public UserResponseWrapper getUserByBugId(Bug existingBug);

	public List<UserResponseWrapper> getAllDevUser();

	public OperationStatusModel activedUser(String id);
	
	public UserResponseWrapper getUserByEmail(String email);


}
