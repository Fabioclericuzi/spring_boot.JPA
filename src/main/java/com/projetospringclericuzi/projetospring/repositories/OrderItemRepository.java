package com.projetospringclericuzi.projetospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetospringclericuzi.projetospring.entities.OrderItem;
import com.projetospringclericuzi.projetospring.entities.pk.OrderItempk;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItempk> {
	
	

}
