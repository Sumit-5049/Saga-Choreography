package com.sagachoreographyos.entity;

import com.sagachoreographyos.event.OrderStatus;
import com.sagachoreographyos.event.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "Purchase_Order")
public class Order {
	
	
	@Id
	@GeneratedValue
	private Integer id;
	private Integer userId;
	private Integer productId;
	private Integer price;
	private Integer quantity;
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Order(Integer id, Integer userId, Integer productId, Integer price, Integer quantity,
			OrderStatus orderStatus, PaymentStatus paymentStatus) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.price = price;
		this.quantity = quantity;
		this.orderStatus = orderStatus;
		this.paymentStatus = paymentStatus;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Order() {
		super();
	}
	
	
	
	
}