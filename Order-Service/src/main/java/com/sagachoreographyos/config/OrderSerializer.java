package com.sagachoreographyos.config;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sagachoreographyos.entity.Order;
import com.sagachoreographyos.event.OrderEvent;




	@Component
	 public class OrderSerializer implements Serializer<OrderEvent> {
	        private final JsonSerializer<Order> jsonSerializer = new JsonSerializer<>();
		
	       
	        private ObjectMapper objectMapper = new ObjectMapper();
		

//	        @Override
//	        public byte[] serialize(String topic, OrderRequestDto data) {
//	            return jsonSerializer.serialize(topic, data);
//	        }

	        
	        
	        @Override
	        public byte[] serialize(String topic, OrderEvent data) {
	            try {
	                return objectMapper.writeValueAsBytes(data);
	            } catch (Exception e) {
	                throw new SerializationException("Error serializing OrderEvent to JSON", e);
	            }
	        }
//		 public byte[] serialize(String topic, OrderRequestDto data) {
//		        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
//		            oos.writeObject(data);
//		            return baos.toByteArray();
//		        } catch (IOException e) {
//		            throw new SerializationException("Error serializing Order to byte[]", e);
//		        }
//		    }
	    }
