package com.sagachoreographyos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.sagachoreographyos.dao.OrderDao;
import com.sagachoreographyos.entity.Order;
import com.sagachoreographyos.event.OrderEvent;
import com.sagachoreographyos.event.OrderStatus;
import com.sagachoreographyos.event.PaymentStatus;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
	
	private final KafkaTemplate<String, OrderEvent> kafkaTemplate;
	
	@Autowired
	private OrderDao dao;
	
	@Autowired
	private OrderPublisher op;
	
	public OrderService(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
	    this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(OrderEvent orderEvent) {
	    kafkaTemplate.send("payment-topic", orderEvent);
	}
	
	@Transactional
	public Order createOrder(Order orderReq) {
		orderReq.setOrderStatus(OrderStatus.ORDER_CREATED);
		Order oRes =dao.save(orderReq);
		OrderEvent orderEvent= new OrderEvent(oRes,OrderStatus.ORDER_CREATED);
		System.out.println("in orderservice: "+orderEvent);
		op.sendMsgtoTopic(orderEvent);
		return oRes;
	}
	

@Transactional
public void cancelOrder(Integer id) {
	
	 dao.findById(id)
	                .ifPresent(d->
	                             {
	                            	 d.setOrderStatus(OrderStatus.ORDER_CANCELLED);
	                            	 d.setPaymentStatus(PaymentStatus.PAYMENT_REFUNDED);
	                            	 dao.save(d);
	                            	 OrderEvent o = convertToDto(d);
	                                 op.sendMsgtoTopic(o);});
		
	}

//	public PurchaseOrder createOrder() {
//		System.out.println("2");
//		op.sendMsgtoTopic("Hii");
//			return null;
//		}

//	public Order convertDtotoEntity(OrderRequestDto dto) {
//		PurchaseOrder purchaseOrder = new PurchaseOrder();
//		purchaseOrder.setProductId(dto.getProductId());
//		purchaseOrder.setUserId(dto.getUserId());
//		purchaseOrder.setOrderStatus(OrderStatus.ORDER_CREATED);
//		purchaseOrder.setPrice(dto.getAmount());
//		return purchaseOrder;
//	}
	
	private OrderEvent convertToDto(Order purchaseOrder) {
		Order orderRequest = new Order();
		orderRequest.setId(purchaseOrder.getId());
		orderRequest.setUserId(purchaseOrder.getUserId());
		orderRequest.setPrice(purchaseOrder.getPrice());
		orderRequest.setProductId(purchaseOrder.getProductId());
		return new OrderEvent(orderRequest,purchaseOrder.getOrderStatus());
	}

	
	
}
