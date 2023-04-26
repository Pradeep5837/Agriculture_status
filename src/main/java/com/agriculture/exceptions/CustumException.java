package com.agriculture.exceptions;

public class CustumException extends Exception {

	private String message;
	
	public CustumException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage()
	{
		return message;
	}
}
