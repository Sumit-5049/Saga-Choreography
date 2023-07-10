package com.sagachoreographyps.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sagachoreographyos.event.OrderEvent;
import com.sagachoreographyos.event.OrderStatus;
import com.sagachoreographyos.event.PaymentEvent;

@Service
public class DemoService {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private KafkaTemplate<String, PaymentEvent> kafkaTemplate;

//	@KafkaListener(topics = "Topic1",groupId = "Group1")
//	public void getMessage(ConsumerRecord<String, OrderRequestDto> message) {
//		OrderRequestDto ord = message.value();
//		System.out.println(ord.getAmount());
//	}
	
//	@KafkaListener(topics = "Topic1",groupId = "Group1")
//	public void getMessages(String message) {
//		//OrderRequestDto ord = message.value();
//		System.out.println(message);
//	}
	
	@KafkaListener(topics = "Topic1",groupId = "Group1")
	 public void listen(String message) throws JsonProcessingException {
		
//		 System.out.println("Hello their");
		
		OrderEvent ord  = objectMapper.readValue(message, OrderEvent.class);
		System.out.println("order in demo : "+ ord);
		sendMsgToTopic(ord);
		
//	        System.out.println(ord.getDate()); // output: John
//	        System.out.println(ord.getEventId());
//	        System.out.println(ord.getOrderStatus());
	       
	    }

private void sendMsgToTopic(OrderEvent ord) {
	
		if(ord.getOrderStatus().equals(OrderStatus.ORDER_CREATED)) {
			System.out.println(".equals success");
			PaymentEvent paymentEvent = paymentService.newOrderEvent(ord);
			kafkaTemplate.send("Topic2",paymentEvent);
		}
		else {
			System.out.println(".equals failure");
			paymentService.cancelOrderEvent(ord);
		}
	
	
}
}