package com.projetospringclericuzi.projetospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetospringclericuzi.projetospring.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {
	
	

}
