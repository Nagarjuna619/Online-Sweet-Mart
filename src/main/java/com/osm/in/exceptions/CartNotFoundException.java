package com.osm.in.exceptions;

public class CartNotFoundException extends RuntimeException {
	public CartNotFoundException(String message) {
		super(message);
	}
	
}