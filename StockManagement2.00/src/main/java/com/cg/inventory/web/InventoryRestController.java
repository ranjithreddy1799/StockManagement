package com.cg.inventory.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.inventory.dto.InventoryForm;
import com.cg.inventory.dto.InventoryMessage;
import com.cg.inventory.entity.InventoryTxn;
import com.cg.inventory.entity.Product;
import com.cg.inventory.entity.Vendor;
import com.cg.inventory.exceptions.InvalidProdIdException;
import com.cg.inventory.exceptions.InvalidVendorIdException;
import com.cg.inventory.exceptions.OutOfStockException;
import com.cg.inventory.service.InventoryTxnService;
import com.cg.inventory.util.InventoryConstants;

public class InventoryRestController {

	@Autowired
	public InventoryTxnService ser;

	@PostMapping("/addinventorytxn")
	public InventoryMessage addInventoryTxn(@RequestBody InventoryForm form) throws OutOfStockException, 
																		InvalidVendorIdException, InvalidProdIdException {
		
		
			ser.addInvTxn(form);
			InventoryMessage msg = new InventoryMessage();
			msg.setMessage(InventoryConstants.SUCCESS_TXN);
		    return msg;
	}

	@GetMapping("/txnofvendor/{vendorId}")
	public List<InventoryTxn> viewTxnsOfSpecVendor(@PathVariable("vendorId") long vendorId)
			throws InvalidVendorIdException {
		List<InventoryTxn> txnlst = ser.txnOfSpecVendor(vendorId);
		
		return txnlst;
	}

	@GetMapping("/viewallProducts")
	public List<Product> viewAllProds() throws InvalidProdIdException {
		return ser.viewAllProoducts();
	}
	
	@GetMapping("/viewallVendors")
	public List<Vendor> viewAllVendors() {
		return ser.viewAllVendors();
	}
}
