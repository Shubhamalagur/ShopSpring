package com.oliver.shopSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oliver.shopSpring.entity.ProductEntity;
import com.oliver.shopSpring.repository.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository repsitory;
	
	public ProductService(ProductRepository repsitory) {
		this.repsitory = repsitory;
	}

	public List<ProductEntity> achaTodas() {
		
		List<ProductEntity> orderlist = repsitory.findAll();
		
		return orderlist;
	} 
	
	public Optional<ProductEntity> achaTodasPorId(Long id) {
		
		Optional<ProductEntity> orderlist = repsitory.findById(id);
		
		
		return orderlist;
	}
//	
	

}
