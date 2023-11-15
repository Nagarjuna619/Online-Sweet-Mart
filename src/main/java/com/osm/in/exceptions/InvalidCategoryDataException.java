package com.osm.in.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class InvalidCategoryDataException extends Exception {
	public InvalidCategoryDataException(String message) {
		super(message);
	}
}
