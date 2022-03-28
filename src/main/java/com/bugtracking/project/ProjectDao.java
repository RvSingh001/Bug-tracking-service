package com.bugtracking.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDao extends JpaRepository<Project, Long> {

	public Project findProjectByProjectId(String projectId);

	public Long deleteByProjectId(String projectId);

}
