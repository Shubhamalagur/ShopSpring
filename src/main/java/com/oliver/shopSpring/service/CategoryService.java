package com.oliver.shopSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oliver.shopSpring.entity.CategoryEntity;
import com.oliver.shopSpring.repository.CategoryRepsitory;

@Service
public class CategoryService {
	
	private  CategoryRepsitory categoryRepsitory;
	
	public CategoryService(CategoryRepsitory categoryRepsitory) {
		this.categoryRepsitory = categoryRepsitory;
	}

	public List<CategoryEntity> achaTodasCategorias() {
		
		List<CategoryEntity> orderlist = categoryRepsitory.findAll();
		
		return orderlist;
	} 
	
	public Optional<CategoryEntity> achaTodasCategoriasPorId(Long id) {
		
		Optional<CategoryEntity> orderlist = categoryRepsitory.findById(id);
		
		
		return orderlist;
	}
//	
	

}
