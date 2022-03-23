package com.bts.bugtracking.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bts.bugtracking.bug.model.Bug;
import com.bts.bugtracking.project.model.Project;
import com.bts.bugtracking.user.model.User;
import com.bts.bugtracking.user.model.User.UserRole;

public interface UserDao extends JpaRepository<User, Long> {

	/**
	 * Dao method used to find a project by id
	 * 
	 * @param projectId String
	 * @return Project
	 */
	public User findUserByUserId(String userId);

	/**
	 * Dao method used to to delete a project by id
	 * 
	 * @param projectId String
	 * @return Project
	 */
	public Long deleteByUserId(String userId);

	public User findByBugs(Bug bugs);

	public List<User> findByRole(UserRole role);

	public User findUserByEmail(String email);

}
