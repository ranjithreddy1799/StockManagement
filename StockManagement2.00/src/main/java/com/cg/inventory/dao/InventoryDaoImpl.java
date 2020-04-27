package com.cg.inventory.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.inventory.entity.InventoryTxn;
import com.cg.inventory.entity.Product;
import com.cg.inventory.entity.User;
import com.cg.inventory.entity.Vendor;
@Repository
public class InventoryDaoImpl implements InventoryDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean addVendor(Vendor vendor) {
		em.persist(vendor);
		return true;
	}

	@Override
	public boolean editVendor(Vendor vendor) {
		em.merge(vendor);
		return true;
	}

	@Override
	public Vendor viewVendor(long vendorId) {
		
		return em.find(Vendor.class, vendorId);
	}

	@Override
	public List<Vendor> viewVendor(String vendorType) {
		String jpql = "from Vendor v where v.vendortype=:vtype";
		TypedQuery<Vendor> query = em.createQuery(jpql, Vendor.class);
		query.setParameter(1, vendorType);
		return query.getResultList();
	}

	@Override
	public boolean addProduct(Product prod) {
		em.persist(prod);
		return true;
	}

	@Override
	public boolean editProduct(Product prod) {
		em.merge(prod);
		return true;
	}

	@Override
	public Product viewProduct(long prodId) {
		
		return em.find(Product.class, prodId);
	}

	@Override
	public List<Product> viewProducts() {
		String jpql = "from Product p";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
		return query.getResultList();
	}
	@Override
	public boolean addInventory(InventoryTxn inventory) {
		em.persist(inventory);
		return true;
	}

	@Override
	public List<InventoryTxn> viewInventory(long vendorId) {
		String jpql = "from InventoryTxn inv inner join fetch inv.prod p inner join fetch inv.vendor v where  v.vendorId=:vid";
		TypedQuery<InventoryTxn> query = em.createQuery(jpql, InventoryTxn.class);
		query.setParameter("vid", vendorId);
		return query.getResultList();
	}

	
	@Override
	public List<InventoryTxn> viewInventoryForVendorType(String vendorType) {
		String jpql = "from InventoryTxn inv inner join fetch inv.prod p inner join fetch inv.vendor v where v.vendortype=:vname";
		TypedQuery<InventoryTxn> query = em.createQuery(jpql, InventoryTxn.class);
		query.setParameter("vname", vendorType);
		
		return query.getResultList();
	}
	@Override
	public List<InventoryTxn> viewInventoryForProductId(long productId, String vendorType) {
		String jpql = "from InventoryTxn inv inner join fetch inv.prod p inner join fetch inv.vendor v where p.productId=:prodid and v.vendortype=:vtype";
		TypedQuery<InventoryTxn> query = em.createQuery(jpql, InventoryTxn.class);
		query.setParameter("prodid", productId);
		query.setParameter("vtype", vendorType);
		return query.getResultList();
	}

	@Override
	public List<InventoryTxn> viewInventory(LocalDate fromDt, LocalDate toDt, String vendorType) {
		String jpql = "from InventoryTxn inv inner join fetch inv.prod p inner join fetch inv.vendor v where inv.dateOfTxn between :fromDt and :toDate and v.vendortype=:vtype";
		TypedQuery<InventoryTxn> query = em.createQuery(jpql, InventoryTxn.class);
		query.setParameter("fromDt", fromDt);
		query.setParameter("toDate", toDt);
		query.setParameter("vtype", vendorType);
		return query.getResultList();
	}

	@Override
	public List<Product> viewInventory(String searchStr) {
		String jpql = "from Product p where p.productName like :str or p.productModel like :str or p.brand like :str";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
		query.setParameter("str", "%"+searchStr+"%");
		return query.getResultList();
	}

	@Override
	public long getMaxTxID() {
		String jpql = "select max(inventoryId) from InventoryTxn";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		
		return query.getSingleResult();
	}

	@Override
	public List<Vendor> viewVendors() {
		String jpql = "from Vendor vendor";
		TypedQuery<Vendor> query = em.createQuery(jpql, Vendor.class);
		
		return query.getResultList();
	}

	@Override
	public User viewUser(String userID) {
		
		return em.find(User.class, userID);
	}

	

}
