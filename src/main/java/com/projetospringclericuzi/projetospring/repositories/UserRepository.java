package com.projetospringclericuzi.projetospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetospringclericuzi.projetospring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	

}
