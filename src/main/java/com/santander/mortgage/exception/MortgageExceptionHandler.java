package com.santander.mortgage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MortgageExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public final ResponseEntity<ErrorResponse> handleUserNotFoundException(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InvalidInputException.class)
	public final ResponseEntity<ErrorResponse> handleInvalidInputException(InvalidInputException ex) {
		ErrorResponse exceptionResponse = new ErrorResponse();
		exceptionResponse.setMessage(ex.getMessage());
		exceptionResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ErrorResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
		ErrorResponse exceptionResponse = new ErrorResponse();
		exceptionResponse.setMessage(ex.getMessage());
		exceptionResponse.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PaymentDetailsNotFoundException.class)
	public final ResponseEntity<ErrorResponse> handlePaymentDetailsNotFoundException(
			PaymentDetailsNotFoundException ex) {
		ErrorResponse exceptionResponse = new ErrorResponse();
		exceptionResponse.setMessage(ex.getMessage());
		exceptionResponse.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PaymentAlreadyDoneException.class)
	public final ResponseEntity<ErrorResponse> handlePaymentAlreadyDoneException(
			PaymentAlreadyDoneException ex) {
		ErrorResponse exceptionResponse = new ErrorResponse();
		exceptionResponse.setMessage(ex.getMessage());
		exceptionResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ErrorResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
