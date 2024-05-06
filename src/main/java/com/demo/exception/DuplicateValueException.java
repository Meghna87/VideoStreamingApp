package com.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateValueException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public DuplicateValueException(String message) {
		super(message);
	}
}
