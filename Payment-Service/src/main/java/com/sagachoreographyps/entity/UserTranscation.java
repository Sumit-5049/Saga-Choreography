package com.sagachoreographyps.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserTranscation {
	@Id
	private Integer orderID;
	private Integer userId;
	private Integer amount;
	public UserTranscation(Integer orderID, Integer userId, Integer amount) {
		super();
		this.orderID = orderID;
		this.userId = userId;
		this.amount = amount;
	}
	public UserTranscation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getOrderID() {
		return orderID;
	}
	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	

}
