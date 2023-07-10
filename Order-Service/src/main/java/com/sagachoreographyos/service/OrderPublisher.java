package com.sagachoreographyos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.sagachoreographyos.event.OrderEvent;

@Service
public class OrderPublisher {
	@Autowired
	KafkaTemplate<String,OrderEvent> kafkaTemplate;
	
	
	public void sendMsgtoTopic(OrderEvent message) {
		System.out.println(message.getClass().getName());
		kafkaTemplate.send("Topic1",message);
	}

}