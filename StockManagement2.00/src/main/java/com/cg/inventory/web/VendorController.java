package com.cg.inventory.web;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.inventory.entity.InventoryTxn;
import com.cg.inventory.exceptions.InvalidProdIdException;
import com.cg.inventory.exceptions.InventoryTxnException;
import com.cg.inventory.service.InventoryService;


@RestController
public class VendorController {
	
	@Autowired
	private InventoryService service;
	
	
	@GetMapping("/salesreport/{productid}")
	public List<InventoryTxn> viewSalesReport(@PathVariable("productid")int productId) throws InvalidProdIdException   {
		List<InventoryTxn> consumerList = service.viewConsumersForProductId(productId);
		
		return consumerList;
	}

	@GetMapping("/purchasereport/{productid}")
	public List<InventoryTxn> viewPurchaseReport(@PathVariable("productid")int productId) throws InvalidProdIdException   {
		List<InventoryTxn> supplierList = service.viewSuppliersForProductId(productId);
		
		return supplierList;
	}
	
	@GetMapping("/purchasereportdate/{fromdt}/{todt}")
	public List<InventoryTxn> viewPurchaseReportForDateRange(@PathVariable("fromdt") @DateTimeFormat(pattern="yyyy-M-d") LocalDate fromDt, @PathVariable("todt") @DateTimeFormat(pattern="yyyy-M-d") LocalDate toDate ) throws InventoryTxnException   {
		List<InventoryTxn> supplierList = service.viewPurchaseRepoForDateRange(fromDt, toDate);
		
		return supplierList;
	}
	
	@GetMapping("/salesreportdate/{fromdt}/{todt}")
	public List<InventoryTxn> viewSaleseReportForDateRange(@PathVariable("fromdt") @DateTimeFormat(pattern="yyyy-M-d") LocalDate fromDt, @PathVariable("todt") @DateTimeFormat(pattern="yyyy-M-d") LocalDate toDate ) throws InventoryTxnException   {
		List<InventoryTxn> salesList = service.viewSalesRepoForDateRange(fromDt, toDate);
		
		return salesList;
	}
	


}