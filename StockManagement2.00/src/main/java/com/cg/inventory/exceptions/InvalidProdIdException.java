package com.cg.inventory.exceptions;

public class InvalidProdIdException extends Exception {

	@Override
	public String toString() {
		return "Invalid Poduct ID";
	}

	public InvalidProdIdException() {
		super();
		
	}

	public InvalidProdIdException(String arg0) {
		super(arg0);
		
	}
	
	
}
