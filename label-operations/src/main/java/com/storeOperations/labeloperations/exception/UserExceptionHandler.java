package com.storeOperations.labeloperations.exception;

import org.springframework.http.HttpStatus;

public class UserExceptionHandler extends RuntimeException {
	
	 private HttpStatus status;
	    private String message;

	    public UserExceptionHandler(HttpStatus status, String message) {
	        this.status = status;
	        this.message = message;
	    }

	    public UserExceptionHandler(String message, HttpStatus status, String message1) {
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
