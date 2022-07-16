package com.oliver.shopSpring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oliver.shopSpring.entity.ProductEntity;
import com.oliver.shopSpring.service.ProductService;

@RestController
@RequestMapping("/products")
//ß@CrossOrigin() 
public class ProductController {
	
	private final ProductService service;
	
	public ProductController(ProductService service) {
		this.service = service;
	}


	@GetMapping
	public ResponseEntity<List<ProductEntity>> acharTodas(){
		
		return ResponseEntity.ok(service.achaTodas());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ProductEntity>> acharTodasPorId(@PathVariable Long id){
		
		return ResponseEntity.ok(service.achaTodasPorId(id));
	}

}
