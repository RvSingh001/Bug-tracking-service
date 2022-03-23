package com.bts.bugtracking.bug.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bts.bugtracking.bug.model.Bug;
import com.bts.bugtracking.project.model.Project;
import com.bts.bugtracking.user.model.User;

@Repository
public interface BugDao extends JpaRepository<Bug, Long> {

	/**
	 * Dao method used to find a bug by id
	 * 
	 * @param bugId String
	 * @return Bug
	 */
	public Bug findByBugId(String id);

	/**
	 * Dao method used to to delete a bug by id
	 * 
	 * @param bugId String
	 * @return Bug
	 */
	public Long deleteByBugId(String bugId);

	/**
	 * Dao method used to get list of bug by project
	 * 
	 * @param bugId String
	 * @return {@code List<Bug>}
	 */
	public List<Bug> findByProject(Project project);

	/**
	 * Dao method used to to get list of bug by user *
	 * 
	 * @param bugId String
	 * @return {@code List<Bug>}
	 */
	public List<Bug> findByUser(User user);

	public List<Bug> findByUserAndProject(User user, Project project);

}
