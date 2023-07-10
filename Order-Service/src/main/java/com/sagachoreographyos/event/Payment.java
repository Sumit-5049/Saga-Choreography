package com.sagachoreographyos.event;




import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class Payment {
	
	private Integer orderId;
	private Integer userId;
	
	private Integer price;
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Payment(Integer orderId, Integer userId, Integer price) {
		super();
		this.userId = userId;
		this.orderId = orderId;
		this.price = price;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
}
