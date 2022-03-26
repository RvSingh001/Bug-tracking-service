package com.bugtracking.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bugtracking.bug.Bug;
import com.bugtracking.bug.IBugService;
import com.bugtracking.project.ProjectServiceException;
import com.bugtracking.user.User.UserRole;
import com.bugtracking.user.shared.ErrorMessages;
import com.bugtracking.user.shared.OperationStatusModel;
import com.bugtracking.user.shared.RequestOperationName;
import com.bugtracking.user.shared.RequestOperationStatus;
import com.bugtracking.utils.BugUtils;

@Service("UserServiceImpl")
public class UserServiceImpl implements IUserService {

	@Autowired
	UserDao userDao;

	@Autowired
	ModelMapper mapper;

	@Autowired
	BugUtils userUtils;

	@Autowired
	IBugService bugService;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * Service Method used to get a project by projectId
	 * 
	 * @param id String
	 * @return returnValue ProjectDetailsWrapper
	 * @throws ProjectServiceException
	 * 
	 **/
	@Override
	public UserResponseWrapper getUser(String id) throws UserServiceException {
		User user = userDao.findUserByUserId(id);
		if (user == null) {
			throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		return mapper.map(user, UserResponseWrapper.class);

	}

	/**
	 * Service Method used to create a project
	 * 
	 * @param projectDetailsWrapper ProjectDetailsWrapper
	 * @return returnValue ProjectDetailsWrapper
	 */
	@Override
	public UserResponseWrapper createUser(UserDetailsWrapper userDetailsWrapper) {

		if (userDao.findUserByEmail(userDetailsWrapper.getEmail()) != null) {
			throw new UserServiceException(ErrorMessages.RECORD_ALREADY_EXISTS.getErrorMessage());
		}
		userDetailsWrapper.setPassword(bCryptPasswordEncoder.encode(userDetailsWrapper.getPassword()));
		String publicId = userUtils.generateUserId(15);
		userDetailsWrapper.setUserId(publicId);
		User user = mapper.map(userDetailsWrapper, User.class);
		user = userDao.save(user);
		return mapper.map(user, UserResponseWrapper.class);
	}

	/**
	 * Service Method used to update a existing project
	 * 
	 * @param id                    String
	 * @param projectDetailsWrapper ProjectDetailsWrapper
	 * @return returnValue ProjectDetailsWrapper
	 * @throws ProjectServiceException
	 * 
	 **/
	@Override
	public UserResponseWrapper updateUser(String id, UserDetailsWrapper userDetailsWrapper)
			throws UserServiceException {
		User storeUser = userDao.findUserByUserId(id);
		if (storeUser == null) {
			throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		storeUser.setFirstName(userDetailsWrapper.getFirstName());
		storeUser.setLastName(userDetailsWrapper.getLastName());
		storeUser.setEmail(userDetailsWrapper.getEmail());
		storeUser.setPassword(bCryptPasswordEncoder.encode(userDetailsWrapper.getPassword()));
		storeUser.setRole(userDetailsWrapper.getRole());
		User returnValue = userDao.save(storeUser);
		return mapper.map(returnValue, UserResponseWrapper.class);
	}

	/**
	 * Service Method used to get all projects
	 * 
	 * @return {@code List<ProjectDetailsWrapper>}
	 * 
	 **/
	@Override
	public List<UserResponseWrapper> getAllUsers() {
		List<User> allUser = userDao.findAll();
		return allUser.stream().map(user -> mapper.map(user, UserResponseWrapper.class)).collect(Collectors.toList());

	}

	/**
	 * Service Method used to delete a existing project by projectId
	 * 
	 * @param id String
	 * @return returnValue OperationStatusModel
	 * 
	 **/
	@Override
	@Transactional
	public OperationStatusModel deleteUser(String id) {
		OperationStatusModel returnValue = new OperationStatusModel();
		returnValue.setOperationName(RequestOperationName.DELETE.name());
		returnValue.setOperationStatus(RequestOperationStatus.ERROR.name());
		userDao.deleteByUserId(id);
		returnValue.setOperationStatus(RequestOperationStatus.SUCCESS.name());
		return returnValue;
	}

	@Override
	public UserResponseWrapper getUserByBugId(Bug existingBug) {
		User user = userDao.findByBugs(existingBug);
		if (user == null) {
			throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		return mapper.map(user, UserResponseWrapper.class);

	}

	@Override
	public List<UserResponseWrapper> getAllDevUser() {
		List<User> devUsers = userDao.findByRole(UserRole.DEVELOPER);
		if (devUsers == null || devUsers.isEmpty()) {
			throw new UserServiceException(ErrorMessages.NO_DEV_USER_FOUND.name());
		}
		return devUsers.stream().map(user -> mapper.map(user, UserResponseWrapper.class)).collect(Collectors.toList());

	}

	@Override
	public OperationStatusModel activedUser(String id) {
		User existingUser = userDao.findUserByUserId(id);
		if (existingUser == null) {
			throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		OperationStatusModel returnValue = new OperationStatusModel();

		boolean status = existingUser.isActive();
		if (status) {
			returnValue.setOperationName(RequestOperationName.DEACTIVE.name());
			existingUser.setActive(false);
		} else {
			returnValue.setOperationName(RequestOperationName.ACTIVE.name());
			existingUser.setActive(true);
		}
		userDao.save(existingUser);
		returnValue.setOperationStatus(RequestOperationStatus.SUCCESS.name());
		return returnValue;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User entity = userDao.findUserByEmail(username);
		if (entity == null) {
			throw new UsernameNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		return new org.springframework.security.core.userdetails.User(entity.getEmail(), entity.getPassword(),
				entity.isActive(), true, true, true, new ArrayList<>());
	}

	@Override
	public UserResponseWrapper getUserByEmail(String email) {
		User entity = userDao.findUserByEmail(email);
		if (entity == null)
			throw new UsernameNotFoundException(email);
		return mapper.map(entity, UserResponseWrapper.class);
	}

}
