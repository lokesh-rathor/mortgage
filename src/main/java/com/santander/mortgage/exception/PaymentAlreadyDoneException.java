package com.santander.mortgage.exception;

public class PaymentAlreadyDoneException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PaymentAlreadyDoneException(String message) {
		super(message);
	}

}
