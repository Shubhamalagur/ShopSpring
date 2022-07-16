package com.oliver.shopSpring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oliver.shopSpring.entity.UserEntity;
import com.oliver.shopSpring.service.UserService;

@RestController
@RequestMapping("/users")
//ß@CrossOrigin() 
public class UserController {
	
	private final UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}


	@GetMapping
	public ResponseEntity<List<UserEntity>> acharTodosUsuarios(){
		
		return ResponseEntity.ok(service.achaTodosUsuarios());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<UserEntity>> acharUsuariosPorId(@PathVariable Long id){
		
		return ResponseEntity.ok(service.achaUsuariosPorId(id));
	}

}
