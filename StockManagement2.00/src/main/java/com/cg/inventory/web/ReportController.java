package com.cg.inventory.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.inventory.entity.InventoryTxn;
import com.cg.inventory.exceptions.InventoryTxnException;
import com.cg.inventory.service.SalesandPurchaseReportService;
import com.cg.inventory.util.InventoryConstants;

@RestController
public class ReportController {

	@Autowired
	private SalesandPurchaseReportService ser;
	
	@GetMapping("/viewsalesreport")
	public List<InventoryTxn> getSalesReport() throws InventoryTxnException   {
		return ser.viewSalesNPurchaseReport(InventoryConstants.CONSUMER);
	}
	
	@GetMapping("/viewpurchasereport")
	public List<InventoryTxn> getPurchaseReport() throws InventoryTxnException  {
		return ser.viewSalesNPurchaseReport(InventoryConstants.SUPPLIER);
	}
	
}
