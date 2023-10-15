package com.projetospringclericuzi.projetospring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetospringclericuzi.projetospring.entities.Category;
import com.projetospringclericuzi.projetospring.entities.Order;
import com.projetospringclericuzi.projetospring.entities.User;
import com.projetospringclericuzi.projetospring.entities.enums.OrderStatus;
import com.projetospringclericuzi.projetospring.repositories.CategoryRepository;
import com.projetospringclericuzi.projetospring.repositories.OrderRepository;
import com.projetospringclericuzi.projetospring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(1, "Electronics"); 
		Category cat2 = new Category(2, "Books"); 
		Category cat3 = new Category(3, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		User u1 = new User(1, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(2, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		
		Order o1 = new Order(10, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1); 
		Order o2 = new Order(11, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2); 
		Order o3 = new Order(12, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

		
	}
	
	
}
