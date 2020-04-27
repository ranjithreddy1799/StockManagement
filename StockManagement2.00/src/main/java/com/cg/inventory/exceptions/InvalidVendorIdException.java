package com.cg.inventory.exceptions;

public class InvalidVendorIdException extends Exception{

	@Override
	public String toString() {
		return "Invalid Vendor Id";
	}
	
	public InvalidVendorIdException() {
		super();
	}
	
	public InvalidVendorIdException(String arg0) {
		super(arg0);
	}

}
