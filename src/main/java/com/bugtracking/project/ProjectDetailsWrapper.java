package com.bugtracking.project;

import com.bugtracking.base.wrapper.BaseWrapper;
import com.bugtracking.project.Project.ProjectStatus;

public class ProjectDetailsWrapper extends BaseWrapper {

	private String projectId;

	private String projectName;

	private String description;

	private String type;

	private String projet_owner;

	private ProjectStatus status;

	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProjet_owner() {
		return projet_owner;
	}

	public void setProjet_owner(String projet_owner) {
		this.projet_owner = projet_owner;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ProjectStatus getStatus() {
		return status;
	}

	public void setStatus(ProjectStatus status) {
		this.status = status;
	}

}
