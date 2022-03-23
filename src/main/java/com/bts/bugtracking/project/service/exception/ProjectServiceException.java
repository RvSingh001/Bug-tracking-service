package com.bts.bugtracking.project.service.exception;

public class ProjectServiceException extends RuntimeException {

	public ProjectServiceException() {
	}

	public ProjectServiceException(String message) {
		super(message);
	}

	public ProjectServiceException(Throwable cause) {
		super(cause);
	}

	public ProjectServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProjectServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
