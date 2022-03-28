package com.bugtracking.user;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bugtracking.user.shared.OperationStatusModel;

@RestController
public class UserRestImpl implements IUserRest {

	@Autowired
	IUserService userServiceImpl;

	Logger logger = LogManager.getLogger(this.getClass());

	@Override
	public List<UserResponseWrapper> getAllUser(String userRole) {
		System.out.print(userRole);
		return userServiceImpl.getAllUsers(userRole);
	}

	@Override
	public UserResponseWrapper createUser(UserDetailsWrapper userDetailsWrapper) {
		logger.info("In UserRestImpl createUser Parameter id {}", userDetailsWrapper.getEmail());
		return userServiceImpl.createUser(userDetailsWrapper);
	}

	@Override
	public UserResponseWrapper getUser(String id) {
		logger.info("In UserRestImpl getProject Parameter id {}", id);
		return userServiceImpl.getUser(id);
	}

	@Override
	public UserResponseWrapper updateUser(String id, UserDetailsWrapper userDetailsWrapper) {
		logger.info("In UserRestImpl updateUser Parameter id {}", id);
		return userServiceImpl.updateUser(id, userDetailsWrapper);
	}

	@Override
	public OperationStatusModel deleteUser(String id) {
		logger.info("In UserRestImpl deleteUser Parameter id {}", id);
		return userServiceImpl.deleteUser(id);
	}

	@Override
	public List<UserResponseWrapper> getAllDeveloper() {
		return userServiceImpl.getAllDevUser();
	}

	@Override
	public OperationStatusModel activateUser(String id) {
		return userServiceImpl.activedUser(id);
	}

}
