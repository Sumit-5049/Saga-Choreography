//package com.sagachoreographyps.event;
//
//import java.util.Date;
//import java.util.UUID;
//
//import com.sagachoreographyps.entity.Payment;
//
//import lombok.NoArgsConstructor;
//@NoArgsConstructor
//public class PaymentEvent implements Event{
//	private UUID eventId = UUID.randomUUID();
//	private Date date = new Date();
//	private Payment payment;
//	private PaymentStatus paymentStatus;
//	@Override
//	public UUID getEventId() {
//		return eventId;
//	}
//	@Override
//	public Date getDate() {
//		return date;
//	}
//	public PaymentEvent(Payment payment, PaymentStatus paymentStatus) {
//		super();
//		this.payment = payment;
//		this.paymentStatus = paymentStatus;
//	}
//}