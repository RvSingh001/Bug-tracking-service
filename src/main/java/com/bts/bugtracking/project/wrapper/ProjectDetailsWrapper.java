package com.bts.bugtracking.project.wrapper;

import com.bts.bugtracking.base.wrapper.BaseWrapper;
import com.bts.bugtracking.project.model.Project.ProjectStatus;

public class ProjectDetailsWrapper extends BaseWrapper {

	private String projectId;

	private String projectName;

	private String description;

	private String type;

	private ProjectStatus status;

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

	@Override
	public String toString() {
		return "ProjectDetailsWrapper [projectId=" + projectId + ", projectName=" + projectName + ", description="
				+ description + ", type=" + type + ", status=" + status + "]";
	}

}
