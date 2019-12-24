package com.mindtree.showmanagement.exceptions.serviceexception;

public class NoSuchChannelGroupFound extends ShowManagementServiceException {

	public NoSuchChannelGroupFound() {
	}

	public NoSuchChannelGroupFound(String description) {
		super(description);
	}

	public NoSuchChannelGroupFound(Throwable description) {
		super(description);
	}

	public NoSuchChannelGroupFound(String description, Throwable cause) {
		super(description, cause);
	}

	public NoSuchChannelGroupFound(String description, Throwable cause, boolean arg2, boolean arg3) {
		super(description, cause, arg2, arg3);
	}

}
