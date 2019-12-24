package com.mindtree.showmanagement.exceptions.serviceexception;

public class NoSuchChannelException extends ShowManagementServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchChannelException() {
	}

	public NoSuchChannelException(String description) {
		super(description);
	}

	public NoSuchChannelException(Throwable description) {
		super(description);
	}

	public NoSuchChannelException(String description, Throwable cause) {
		super(description, cause);
	}

	public NoSuchChannelException(String description, Throwable cause, boolean arg2, boolean arg3) {
		super(description, cause, arg2, arg3);
	}

}
