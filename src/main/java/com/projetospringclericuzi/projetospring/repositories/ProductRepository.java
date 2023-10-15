package com.projetospringclericuzi.projetospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetospringclericuzi.projetospring.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
	
	

}
