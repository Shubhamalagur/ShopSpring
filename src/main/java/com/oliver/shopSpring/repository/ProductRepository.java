package com.oliver.shopSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oliver.shopSpring.entity.ProductEntity;

@Repository
public
interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
