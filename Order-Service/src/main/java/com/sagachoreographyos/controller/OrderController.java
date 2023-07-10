package com.sagachoreographyos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagachoreographyos.entity.Order;
import com.sagachoreographyos.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService service;
	
	@PostMapping("/create")
	public ResponseEntity<Order> createOrder(@RequestBody Order orderReq) {
		return new ResponseEntity<Order>(service.createOrder(orderReq) , HttpStatus.OK);	
	}
	@DeleteMapping("cancle/{id}")	
	private String cancelOrderItem(@PathVariable int id) {
		service.cancelOrder(id);
		return "Your Order is cancelled";
	}
	
}
