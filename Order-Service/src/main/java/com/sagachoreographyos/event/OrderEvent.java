package com.sagachoreographyos.event;

import java.util.Date;
import java.util.UUID;

import com.sagachoreographyos.entity.Order;

public class OrderEvent implements Event{
	private UUID eventId = UUID.randomUUID();
	private Date date = new Date();
	private Order order;
	private OrderStatus orderStatus;
	@Override
	public UUID getEventId() {
		return eventId;
	}
	@Override
	public String toString() {
		return "OrderEvent [eventId=" + eventId + ", date=" + date + ", order=" + order + ", orderStatus=" + orderStatus
				+ "]";
	}
	@Override
	public Date getDate() {
		return date;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public void setEventId(UUID eventId) {
		this.eventId = eventId;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public OrderEvent(Order order, OrderStatus orderStatus) {
		super();
		this.order = order;
		this.orderStatus = orderStatus;
	}
	public OrderEvent() {
		super();
	}
}

