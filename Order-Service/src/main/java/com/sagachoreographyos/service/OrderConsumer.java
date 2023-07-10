package com.sagachoreographyos.service;


import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sagachoreographyos.dao.OrderDao;
import com.sagachoreographyos.entity.Order;
import com.sagachoreographyos.event.OrderEvent;
import com.sagachoreographyos.event.OrderStatus;
import com.sagachoreographyos.event.PaymentEvent;
import com.sagachoreographyos.event.PaymentStatus;

import jakarta.transaction.Transactional;

@Service
public class OrderConsumer {
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private OrderDao orderRepository;
	@Autowired
	private OrderPublisher orderPublisher;
	
	
	
	@KafkaListener(topics = "Topic2",groupId = "Group2")
	public void paymentEventListner(String message) throws JsonMappingException, JsonProcessingException {
		PaymentEvent pe = objectMapper.readValue(message,PaymentEvent.class);
		System.out.println(pe.getPaymentStatus());
		handlePaymentEvent(pe.getPayment().getOrderId(),p->{p.setPaymentStatus(pe.getPaymentStatus());});
	}

	@Transactional
	private void handlePaymentEvent(int id,Consumer<Order> consumer) {
		System.out.println(id);
	 orderRepository.findById(id).ifPresent(consumer.andThen(this::updateOrder));
		
	}
	
	public void updateOrder(Order purchaseOrder) {
		
		boolean isPaymentComplete = PaymentStatus.PAYMENT_COMPLETED.equals(purchaseOrder.getPaymentStatus());
		System.out.println(isPaymentComplete);
		OrderStatus orderStatus = isPaymentComplete ? OrderStatus.ORDER_COMPLETED : OrderStatus.ORDER_CANCELLED;
		purchaseOrder.setOrderStatus(orderStatus);
		orderRepository.save(purchaseOrder);
		//orderPublisher.sendMsgtoTopic(convertToDto(purchaseOrder));
		if(!isPaymentComplete) {
			orderPublisher.sendMsgtoTopic(convertToDto(purchaseOrder));
		}
	}

	private OrderEvent convertToDto(Order purchaseOrder) {
		Order orderRequestDto = new Order();
		orderRequestDto.setId(purchaseOrder.getId());
		orderRequestDto.setUserId(purchaseOrder.getUserId());
		orderRequestDto.setPrice(purchaseOrder.getPrice());
		orderRequestDto.setProductId(purchaseOrder.getProductId());
		return new OrderEvent(orderRequestDto,purchaseOrder.getOrderStatus());
	}
	

	
}