package com.onlinesweetmart.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UserAlreadyExistsException extends RuntimeException{
	
	
	public UserAlreadyExistsException(String message) {
		super(message);
	}
}
