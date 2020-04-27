package com.cg.inventory.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.inventory.exceptions.InvalidProdIdException;
import com.cg.inventory.exceptions.InvalidVendorIdException;
import com.cg.inventory.exceptions.InventoryTxnException;
import com.cg.inventory.exceptions.LoginException;
import com.cg.inventory.exceptions.OutOfStockException;

@RestControllerAdvice
public class VendorTypeExceptionAdvice {
	
	Logger logger = LoggerFactory.getLogger(VendorTypeExceptionAdvice.class);
	
	@ExceptionHandler(value = {InvalidProdIdException.class})
	@ResponseStatus(code= HttpStatus.NOT_FOUND,reason="Unknown Product")
	public void  handleException(Exception ex) {
		logger.error(ex.getMessage());
	}

	@ExceptionHandler(value = {InvalidVendorIdException.class})
	@ResponseStatus(code= HttpStatus.NOT_FOUND,reason="Unknown Vendor")
	public void  handleException2(Exception ex) {
		logger.error(ex.getMessage());	
	}
	
	@ExceptionHandler(value = {OutOfStockException.class, InventoryTxnException.class, LoginException.class})
	@ResponseStatus(code= HttpStatus.BAD_REQUEST)
	public ErrorInfo  handleExceptio3(Exception ex) {
		logger.error(ex.getMessage());
		ErrorInfo error = new ErrorInfo();
		error.setMessage(ex.getMessage());
		return error;
	}
}
