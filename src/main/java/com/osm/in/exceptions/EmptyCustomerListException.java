package com.osm.in.exceptions;

public class EmptyCustomerListException extends RuntimeException{
	public EmptyCustomerListException(String message) {
		super(message);
	}
}
