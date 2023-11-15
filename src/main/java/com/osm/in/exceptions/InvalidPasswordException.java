package com.osm.in.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class InvalidPasswordException extends RuntimeException{	
	public InvalidPasswordException(String message) {
		super(message);
	}		
}
