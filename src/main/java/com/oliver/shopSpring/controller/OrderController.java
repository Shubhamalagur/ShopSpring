package com.oliver.shopSpring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oliver.shopSpring.entity.OrderEntity;
import com.oliver.shopSpring.service.OrderService;

@RestController
@RequestMapping("/orders")
//ß@CrossOrigin() 
public class OrderController {
	
	private final OrderService service;
	
	public OrderController(OrderService service) {
		this.service = service;
	}


	@GetMapping
	public ResponseEntity<List<OrderEntity>> acharTodasOrders(){
		
		return ResponseEntity.ok(service.achaTodasOrders());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<OrderEntity>> acharTodasOrderPorId(@PathVariable Long id){
		
		return ResponseEntity.ok(service.achaTodasOrderPorId(id));
	}

}
