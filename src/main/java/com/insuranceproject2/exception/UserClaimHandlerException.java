package com.insuranceproject2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserClaimHandlerException {

	@ExceptionHandler(value = { IncompleteDetailsFilledException.class })
	public ResponseEntity<Object> handleUser(IncompleteDetailsFilledException incompleteDetailsFilledException) {
		UserClaimException userClaimException = new UserClaimException(incompleteDetailsFilledException.getMessage());
		return new ResponseEntity<Object>(userClaimException, HttpStatus.NOT_FOUND);

	}
}
