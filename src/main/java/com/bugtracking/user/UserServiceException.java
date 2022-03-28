package com.bugtracking.user;

public class UserServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserServiceException() {
	}

	public UserServiceException(String message) {
		super(message);
	}

	public UserServiceException(Throwable cause) {
		super(cause);
	}

	public UserServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
