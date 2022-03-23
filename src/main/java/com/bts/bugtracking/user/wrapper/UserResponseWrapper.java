package com.bts.bugtracking.user.wrapper;

import com.bts.bugtracking.base.wrapper.BaseWrapper;
import com.bts.bugtracking.user.model.User.UserRole;

public class UserResponseWrapper extends BaseWrapper {

	private String userId;

	private String firstName;

	private String lastName;

	private String email;

	private UserRole role;

	private boolean isActive;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "UserDetailsWrapper [userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", role=" + role + "]";
	}

}
