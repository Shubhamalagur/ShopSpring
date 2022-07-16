package com.oliver.shopSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliver.shopSpring.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
