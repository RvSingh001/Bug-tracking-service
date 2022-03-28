package com.bugtracking.bug;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bugtracking.project.Project;
import com.bugtracking.user.User;

@Repository
public interface BugDao extends JpaRepository<Bug, Long> {

	public Bug findByBugId(String id);

	public Long deleteByBugId(String bugId);

	public List<Bug> findByProject(Project project);

	public List<Bug> findByUser(User user);

	public List<Bug> findByUserAndProject(User user, Project project);

}
