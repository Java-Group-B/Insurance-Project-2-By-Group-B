package com.insuranceproject2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserDetailsHandlerException {

	@ExceptionHandler(value = {IncompleteDetailsFilledException.class })
	public ResponseEntity<Object> handleUser(IncompleteDetailsFilledException incompleteDetailsFilledException) {
		UserDetailsException userDetailsException = new UserDetailsException(incompleteDetailsFilledException.getMessage());
		return new ResponseEntity<Object>(userDetailsException, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = {UserNotFoundException.class })
	public ResponseEntity<Object> handleUserData(UserNotFoundException userNotFoundException) {
		UserDetailsException userDetailsException = new UserDetailsException(userNotFoundException.getMessage());
		return new ResponseEntity<>(userDetailsException, HttpStatus.NOT_FOUND);
	}
}
