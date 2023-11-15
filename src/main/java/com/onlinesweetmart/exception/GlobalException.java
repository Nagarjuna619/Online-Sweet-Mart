package com.onlinesweetmart.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<String> handleCustomException(CustomException exc){
		return new ResponseEntity<String>(exc.getLocalizedMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> handleIdNotNotFoundException(IdNotFoundException exc){
		return new ResponseEntity<String>(exc.getLocalizedMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidCategoryDataException.class)
	public ResponseEntity<String> handleInvalidCategoryDataException(InvalidCategoryDataException exc){
		return new ResponseEntity<String>(exc.getLocalizedMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException exc){
		return new ResponseEntity<String>(exc.getLocalizedMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyProductListException.class)
	public ResponseEntity<String> handleEmptyProductListException(EmptyProductListException exc){
		return new ResponseEntity<String>(exc.getLocalizedMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyCategoryListException.class)
	public ResponseEntity<String> handleEmptyCategoryListException(EmptyCategoryListException exc){
		return new ResponseEntity<String>(exc.getLocalizedMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidUserNameException.class)
	public ResponseEntity<String> handleInvalidUserNameException(InvalidUserNameException exc){
		return new ResponseEntity<String>(exc.getLocalizedMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<String> handleInvalidPasswordException(InvalidPasswordException exc){
		return new ResponseEntity<String>(exc.getLocalizedMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PasswordMismatchException.class)
	public ResponseEntity<String> handlePasswordMismatchException(PasswordMismatchException exc){
		return new ResponseEntity<String>(exc.getLocalizedMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyCustomerListException.class)
	public ResponseEntity<String> handleEmptyCustomerListException(EmptyCustomerListException exc){
		return new ResponseEntity<String>(exc.getLocalizedMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyUserListException.class)
	public ResponseEntity<String> handleEmptyUserListException(EmptyUserListException exc){
		return new ResponseEntity<String>(exc.getLocalizedMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<String> handleUserAlreadyExistsException(UserAlreadyExistsException exc){
		return new ResponseEntity<String>(exc.getLocalizedMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CartNotFoundException.class)
	public ResponseEntity<String> handleCartNotFoundException(CartNotFoundException exc){
		return new ResponseEntity<String>(exc.getLocalizedMessage(),HttpStatus.NOT_FOUND);
	}

}
