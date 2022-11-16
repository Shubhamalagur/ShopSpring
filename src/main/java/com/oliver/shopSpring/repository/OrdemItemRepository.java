package com.oliver.shopSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliver.shopSpring.entity.OrdemItem;

public interface OrdemItemRepository extends JpaRepository<OrdemItem, Long> {

}
