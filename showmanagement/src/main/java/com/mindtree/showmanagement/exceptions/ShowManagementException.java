package com.mindtree.showmanagement.exceptions;

public class ShowManagementException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShowManagementException() {
	}

	public ShowManagementException(String description) {
		super(description);
	}

	public ShowManagementException(Throwable description) {
		super(description);
	}

	public ShowManagementException(String description, Throwable cause) {
		super(description, cause);
	}

	public ShowManagementException(String description, Throwable cause, boolean arg2, boolean arg3) {
		super(description, cause, arg2, arg3);
	}

}
