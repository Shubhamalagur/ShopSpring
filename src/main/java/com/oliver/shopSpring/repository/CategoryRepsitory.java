package com.oliver.shopSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oliver.shopSpring.entity.CategoryEntity;
import com.oliver.shopSpring.entity.OrderEntity;

@Repository
public
interface CategoryRepsitory extends JpaRepository<CategoryEntity, Long> {

}
