package com.insuranceproject2.exception;

public class UserClaimException {

	private final String message;

	public UserClaimException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
