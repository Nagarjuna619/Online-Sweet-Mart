package com.osm.in.exceptions;




public class PasswordMismatchException extends RuntimeException{
	public PasswordMismatchException(String message) {
		super(message);
	}	
}
