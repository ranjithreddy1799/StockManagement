package com.cg.inventory.service;

import java.util.List;

import com.cg.inventory.entity.InventoryTxn;
import com.cg.inventory.entity.Product;
import com.cg.inventory.exceptions.InvalidProdIdException;
import com.cg.inventory.exceptions.InventoryTxnException;

public interface SalesandPurchaseReportService {

	public List<InventoryTxn> viewSalesNPurchaseReport(String vendorType) throws InventoryTxnException ;
	public List<Product> searchInventory(String searchStr) throws InvalidProdIdException;
	
	
}
