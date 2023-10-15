package com.projetospringclericuzi.projetospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetospringclericuzi.projetospring.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	

}
