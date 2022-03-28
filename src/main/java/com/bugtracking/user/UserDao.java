package com.bugtracking.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugtracking.bug.Bug;
import com.bugtracking.project.Project;
import com.bugtracking.user.User.UserRole;

public interface UserDao extends JpaRepository<User, Long> {

	public User findUserByUserId(String userId);

	public Long deleteByUserId(String userId);

	public User findByBugs(Bug bugs);

	public List<User> findByRole(UserRole role);

	public User findUserByEmail(String email);

}
