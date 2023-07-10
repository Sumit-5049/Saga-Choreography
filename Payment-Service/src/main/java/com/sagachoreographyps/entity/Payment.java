//package com.sagachoreographyps.entity;
//
//
//import com.sagachoreographyos.event.PaymentStatus;
//
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//
//public class Payment {
//	private Integer userId;
//	private Integer orderId;
//	private Integer price;
//	@Enumerated(EnumType.STRING)
//	private PaymentStatus paymentStatus;
//	public Integer getUserId() {
//		return userId;
//	}
//	public void setUserId(Integer userId) {
//		this.userId = userId;
//	}
//	public Integer getOrderId() {
//		return orderId;
//	}
//	public void setOrderId(Integer orderId) {
//		this.orderId = orderId;
//	}
//	public Integer getPrice() {
//		return price;
//	}
//	public void setPrice(Integer price) {
//		this.price = price;
//	}
//	public PaymentStatus getPaymentStatus() {
//		return paymentStatus;
//	}
//	public void setPaymentStatus(PaymentStatus paymentStatus) {
//		this.paymentStatus = paymentStatus;
//	}
//	public Payment(Integer userId, Integer orderId, Integer price) {
//		super();
//		this.userId = userId;
//		this.orderId = orderId;
//		this.price = price;
//	}
//	public Payment() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
//}
