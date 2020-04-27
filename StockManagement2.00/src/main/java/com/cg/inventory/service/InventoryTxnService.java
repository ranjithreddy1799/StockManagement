package com.cg.inventory.service;

import java.util.List;

import com.cg.inventory.dto.InventoryForm;
import com.cg.inventory.entity.InventoryTxn;
import com.cg.inventory.entity.Product;
import com.cg.inventory.entity.Vendor;
import com.cg.inventory.exceptions.InvalidProdIdException;
import com.cg.inventory.exceptions.InvalidVendorIdException;
import com.cg.inventory.exceptions.OutOfStockException;

public interface InventoryTxnService {

	public boolean addInvTxn(InventoryForm form) throws OutOfStockException, InvalidVendorIdException, InvalidProdIdException;
	public List<Product> viewAllProoducts() throws InvalidProdIdException;
	public List<Vendor> viewAllVendors() ;
	public List<InventoryTxn> txnOfSpecVendor(long vendorId) throws InvalidVendorIdException;
}
