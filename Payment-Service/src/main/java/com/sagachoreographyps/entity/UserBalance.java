package com.sagachoreographyps.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserBalance {
	
	@Id
	private Integer userId;
	private Integer balance;
	public UserBalance(Integer userId, Integer balance) {
		super();
		this.userId = userId;
		this.balance = balance;
	}
	public UserBalance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
	
}
