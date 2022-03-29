package com.bugtracking.project;

import com.bugtracking.base.wrapper.BaseWrapper;
import com.bugtracking.project.Project.ProjectStatus;

public class ProjectDetailsWrapper extends BaseWrapper {

	private String projectId;

	private String projectName;

	private String description;

	private String type;

	private String createby;

	private String projet_owner;

	private ProjectStatus status;

	public String getProjet_owner() {
		return projet_owner;
	}

	public void setProjet_owner(String projet_owner) {
		this.projet_owner = projet_owner;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
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

	@Override
	public String toString() {
		return "ProjectDetailsWrapper [projectId=" + projectId + ", projectName=" + projectName + ", description="
				+ description + ", type=" + type + ", createby=" + createby + ", projet_owner=" + projet_owner
				+ ", status=" + status + "]";
	}

}
