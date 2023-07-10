package com.sagachoreographyps.config;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.stereotype.Component;

import com.sagachoreographyos.entity.Order;


@Component
public class CustomDeserializer implements Deserializer<Order>{

	@Override
    public Order deserialize(String topic, byte[] data) {
		System.out.println(data.toString());
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(bais)) {
            return (Order) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new SerializationException("Error deserializing byte[] to Order", e);
        }
		
    }
	
	  @Override
	    public void configure(Map<String, ?> configs, boolean isKey) {
	        // No additional configuration is required
	    }

	    @Override
	    public void close() {
	        // No resources need to be released
	    }

}
