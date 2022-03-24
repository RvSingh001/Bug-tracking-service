package com.bugtracking.bug;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bugtracking.base.model.BaseEntity;
import com.bugtracking.project.Project;
import com.bugtracking.user.User;

/**
 * The {@code Bug} class represents mapping [Entity class] to database table
 * Bug.
 */
@Entity
@Table(name = "bug")
public class Bug extends BaseEntity {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "bugid_pk")
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "bug_id")
	private String bugId;

	@Column(name = "description")
	private String description;

	@Column(name = "type")
	private String type;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private BugStatus status;

	@Column(name = "piority")
	@Enumerated(EnumType.STRING)
	private BugPriority priority;

	@ManyToOne
	@JoinColumn(name = "projectid_fk", nullable = false)
	private Project project;

	@ManyToOne
	@JoinColumn(name = "userid_fk", nullable = false)
	private User user;

	@Column(name = "created_by")
	private String createdBy;

	public Bug() {
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBugId() {
		return bugId;
	}

	public void setBugId(String bugId) {
		this.bugId = bugId;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public enum BugStatus {
		FIX, OPEN, CLOSE, NOT_AN_ISSUE, IN_PROGRESS
	}

	public enum BugPriority {
		LOW, MEDIUM, HIGH;
	}
}
