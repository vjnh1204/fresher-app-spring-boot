package com.vinh.fresherApp.exception;

import org.springframework.http.HttpStatus;

public class FresherAPIException extends RuntimeException {
	private HttpStatus status;
	private String message;

	public FresherAPIException(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public FresherAPIException(String message, HttpStatus status, String message1) {
		super(message);
		this.status = status;
		this.message = message1;
	}

	public HttpStatus getStatus() {
		return status;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
