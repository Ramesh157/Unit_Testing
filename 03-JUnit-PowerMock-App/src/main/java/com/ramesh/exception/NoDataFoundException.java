package com.ramesh.exception;

public class NoDataFoundException extends RuntimeException{

	public NoDataFoundException() {
		
	}
	
    private static final long SerialVersionUID = 101; 	
	public NoDataFoundException(String msg) {
		super(msg);
		
	}

}
