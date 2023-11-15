package com.osm.in.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class IdNotFoundException extends RuntimeException{
	
	
	public IdNotFoundException(String message) {
		super(message);
	}
}
