package com.epam.library.service;

public class IllegalCodeException extends Exception{
	private static final long serialVersionUID = 1L;

	public IllegalCodeException(String message) {
		super(message);
	}
	
	public IllegalCodeException(Exception e) {
		super(e);
	}
	
	public IllegalCodeException(String message, Exception e) {
		super(message, e);
	}
}
