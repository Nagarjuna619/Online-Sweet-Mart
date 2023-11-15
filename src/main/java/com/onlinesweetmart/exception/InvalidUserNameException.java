package com.onlinesweetmart.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class InvalidUserNameException extends RuntimeException{
	public InvalidUserNameException(String message) {
		super(message);
	}		
}
