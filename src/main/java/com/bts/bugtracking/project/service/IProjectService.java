package com.bts.bugtracking.project.service;

import java.util.List;

import com.bts.bugtracking.bug.wrapper.BugDetailsWrapper;
import com.bts.bugtracking.project.wrapper.ProjectDetailsWrapper;
import com.bts.bugtracking.shared.OperationStatusModel;

public interface IProjectService {
	public ProjectDetailsWrapper getProject(String id);

	public ProjectDetailsWrapper createProject(ProjectDetailsWrapper projectDetailsWrapper);

	public ProjectDetailsWrapper updateProject(String id, ProjectDetailsWrapper projectDetailsWrapper);

	public List<ProjectDetailsWrapper> getAllProjects();

	public OperationStatusModel deleteProject(String id);

	public List<BugDetailsWrapper> getAllBugByProjectId(String id);
	
}
