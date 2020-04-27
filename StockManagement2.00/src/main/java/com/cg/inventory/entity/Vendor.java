package com.cg.inventory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="lpu_vendor")
public class Vendor {

	@Id
	@Column(name="vendor_id")
	private long vendorId;
	@Column(name="vendor_name", length=25)
	private String companyName;
	@Column(name="vendor_addr", length=25)
	private String address;
	@Column(name="vendor_area", length=25)
	private String area;
	@Column(name="vendor_contact", length=25)
	private String contact;
	@Column(name="vendor_city", length=25)
	private String city;
	@Column(name="vendor_type", length=25)
	private String vendortype;
	
	public String getVendortype() {
		return vendortype;
	}
	public void setVendortype(String vendortype) {
		this.vendortype = vendortype;
	}
	public long getVendorId() {
		return vendorId;
	}
	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}
