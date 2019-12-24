package com.mindtree.showmanagement.exceptions.serviceexception;

import com.mindtree.showmanagement.exceptions.ShowManagementException;

public class ShowManagementServiceException extends ShowManagementException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShowManagementServiceException() {
	}

	public ShowManagementServiceException(String description) {
		super(description);
	}

	public ShowManagementServiceException(Throwable description) {
		super(description);
	}

	public ShowManagementServiceException(String description, Throwable cause) {
		super(description, cause);
	}

	public ShowManagementServiceException(String description, Throwable cause, boolean arg2, boolean arg3) {
		super(description, cause, arg2, arg3);
	}

}
