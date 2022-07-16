package com.oliver.shopSpring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oliver.shopSpring.entity.CategoryEntity;
import com.oliver.shopSpring.service.CategoryService;

@RestController
@RequestMapping("/categorys")
//ß@CrossOrigin() 
public class CategoryController {
	
	private final CategoryService service;
	
	public CategoryController(CategoryService service) {
		this.service = service;
	}


	@GetMapping
	public ResponseEntity<List<CategoryEntity>> acharTodas(){
		
		return ResponseEntity.ok(service.achaTodasCategorias());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<CategoryEntity>> acharTodasPorId(@PathVariable Long id){
		
		return ResponseEntity.ok(service.achaTodasCategoriasPorId(id));
	}

}
