package com.cg.inventory.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.inventory.dao.InventoryDao;
import com.cg.inventory.entity.InventoryTxn;
import com.cg.inventory.exceptions.InvalidProdIdException;
import com.cg.inventory.exceptions.InventoryTxnException;
import com.cg.inventory.util.InventoryConstants;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	private InventoryDao dao;

	@Override
	public List<InventoryTxn> viewSuppliersForProductId(long productId)
			throws InvalidProdIdException {
		List<InventoryTxn> suppliersList = dao.viewInventoryForProductId(productId, InventoryConstants.SUPPLIER);
		if(suppliersList.isEmpty())
			throw new InvalidProdIdException(InventoryConstants.NOSUPPLIER);
		suppliersList.sort((t1, t2) ->t2.getDateOfTxn().compareTo(t1.getDateOfTxn()));
		return suppliersList;
	}

	@Override
	public List<InventoryTxn> viewConsumersForProductId(long productId)
			throws InvalidProdIdException {
		List<InventoryTxn> consumersList = dao.viewInventoryForProductId(productId, InventoryConstants.CONSUMER);
		if(consumersList.isEmpty())
			throw new InvalidProdIdException(InventoryConstants.NOCONSUMER);
		consumersList.sort((t1, t2) ->t2.getDateOfTxn().compareTo(t1.getDateOfTxn()));
		return consumersList;
	}
	
	@Override
	public List<InventoryTxn> viewSalesRepoForDateRange(LocalDate fromDt , LocalDate toDate) throws InventoryTxnException{
			 
		List<InventoryTxn> salesList = dao.viewInventory(fromDt, toDate, InventoryConstants.CONSUMER);
		if(salesList.isEmpty())
			throw new InventoryTxnException();
		salesList.sort((t1, t2) ->t2.getDateOfTxn().compareTo(t1.getDateOfTxn()));
		return salesList;
	}

	
	@Override
	public List<InventoryTxn> viewPurchaseRepoForDateRange(LocalDate fromDt , LocalDate toDate) throws InventoryTxnException{
			 
		List<InventoryTxn> salesList = dao.viewInventory(fromDt, toDate, InventoryConstants.SUPPLIER);
		if(salesList.isEmpty())
			throw new InventoryTxnException(InventoryConstants.NO_TRANSACTIONS);
		salesList.sort((t1, t2) ->t2.getDateOfTxn().compareTo(t1.getDateOfTxn()));
		return salesList;
	}
}
