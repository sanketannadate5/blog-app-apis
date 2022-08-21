package com.sanket.blogappapis.exceptions;

public class ApiException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 923727831984603366L;

	public ApiException(String message) {
		super(message);
	}

	public ApiException() {
		super();
		// TODO Auto-generated constructor stub
	}
}
