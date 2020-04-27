package com.cg.inventory.exceptions;

public class OutOfStockException extends Exception {

	@Override
	public String toString() {
		return "The Selected the product is out of stock";
	}

	public OutOfStockException() {
		super();
	}
	
	public OutOfStockException(String arg0) {
		super(arg0);
	}
	
	

	
}
