package com.bugtracking.bug;

public class BugServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BugServiceException() {
	}

	public BugServiceException(String message) {
		super(message);
	}

	public BugServiceException(Throwable cause) {
		super(cause);
	}

	public BugServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public BugServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
