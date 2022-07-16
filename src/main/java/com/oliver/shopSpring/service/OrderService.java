package com.oliver.shopSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oliver.shopSpring.entity.OrderEntity;
import com.oliver.shopSpring.repository.OrderRepsitory;

@Service
public class OrderService {
	
	private  OrderRepsitory orderRepsitory;
	
	public OrderService(OrderRepsitory orderRepsitory) {
		this.orderRepsitory = orderRepsitory;
	}

	public List<OrderEntity> achaTodasOrders() {
		
		List<OrderEntity> orderlist = orderRepsitory.findAll();
		
		return orderlist;
	}
	
	public Optional<OrderEntity> achaTodasOrderPorId(Long id) {
		
		Optional<OrderEntity> orderlist = orderRepsitory.findById(id);
		
		
		return orderlist;
	}
//	
	

}
