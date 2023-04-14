package com.spro.exception;

public class PaymentException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8162266219947052321L;

	public PaymentException(String message) {
		super(message);
	}
}
