package com.bugtracking.bug;

import com.bugtracking.base.wrapper.BaseWrapper;
import com.bugtracking.bug.Bug.BugPriority;
import com.bugtracking.bug.Bug.BugStatus;

public class BugDetailsWrapper extends BaseWrapper {

	private String bugId;

	private String title;

	private String description;

	private String type;

	private BugStatus status;

	private BugPriority priority;

	private String projectId;

	private String userId;
	
	private String createdBy;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBugId() {
		return bugId;
	}

	public void setBugId(String bugId) {
		this.bugId = bugId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public BugStatus getStatus() {
		return status;
	}

	public void setStatus(BugStatus status) {
		this.status = status;
	}

	public BugPriority getPriority() {
		return priority;
	}

	public void setPriority(BugPriority priority) {
		this.priority = priority;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
