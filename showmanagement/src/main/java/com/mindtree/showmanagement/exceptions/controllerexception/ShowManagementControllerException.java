package com.mindtree.showmanagement.exceptions.controllerexception;

import com.mindtree.showmanagement.exceptions.ShowManagementException;

public class ShowManagementControllerException extends ShowManagementException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShowManagementControllerException() {
	}

	public ShowManagementControllerException(String description) {
		super(description);
	}

	public ShowManagementControllerException(Throwable description) {
		super(description);
	}

	public ShowManagementControllerException(String description, Throwable cause) {
		super(description, cause);
	}

	public ShowManagementControllerException(String description, Throwable cause, boolean arg2, boolean arg3) {
		super(description, cause, arg2, arg3);
	}

}
