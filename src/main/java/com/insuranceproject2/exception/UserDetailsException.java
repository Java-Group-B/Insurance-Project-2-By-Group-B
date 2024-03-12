package com.insuranceproject2.exception;

public class UserDetailsException {

	private final String message;

	public UserDetailsException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
