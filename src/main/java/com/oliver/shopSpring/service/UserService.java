package com.oliver.shopSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oliver.shopSpring.entity.UserEntity;
import com.oliver.shopSpring.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}



	public List<UserEntity> achaTodosUsuarios() {
		
		List<UserEntity> userList = userRepository.findAll();
		
		return userList;
	}
	
	public Optional<UserEntity> achaUsuariosPorId(Long id) {
		
		Optional<UserEntity> userList = userRepository.findById(id);
		
		
		return userList;
	}
	
	

}
