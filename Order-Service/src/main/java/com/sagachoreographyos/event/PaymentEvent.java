package com.sagachoreographyos.event;

import java.util.Date;
import java.util.UUID;


public class PaymentEvent implements Event{
	
	private UUID eventId = UUID.randomUUID();
	private Date date = new Date();
	private Payment payment;
	private PaymentStatus paymentStatus;
	@Override
	public UUID getEventId() {
		return eventId;
	}
	@Override
	public Date getDate() {
		return date;
	}
	public PaymentEvent(Payment payment, PaymentStatus paymentStatus) {
		super();
		this.payment = payment;
		this.paymentStatus = paymentStatus;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public PaymentEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
}