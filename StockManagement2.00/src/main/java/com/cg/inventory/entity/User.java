package com.cg.inventory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Inventory_user")
@DynamicInsert
@DynamicUpdate
public class User {

	@Id
	@Column(name="user_id", length=20)
	private String userID;
	@JsonIgnore
	@Column(name="password", length=20)
	private String password;
	@Column(name="user_anme", length=20)
	private String userName;
	@Column(name="role", length=20)
	private String role;
	
	public User() {
		
	}
	public User(String userID, String password, String userName, String role) {
		super();
		this.userID = userID;
		this.password = password;
		this.userName = userName;
		this.role = role;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
