package com.cg.inventory.exceptions;

public class InventoryTxnException extends Exception{

	public InventoryTxnException() {
		super();
	}

	@Override
	public String toString() {
		return "Transaction id already exists";
	}
	
	public InventoryTxnException(String arg0) {
		super(arg0);
	}
   
	
}
