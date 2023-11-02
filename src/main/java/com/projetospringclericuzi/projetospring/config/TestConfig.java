package com.projetospringclericuzi.projetospring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetospringclericuzi.projetospring.entities.Category;
import com.projetospringclericuzi.projetospring.entities.Order;
import com.projetospringclericuzi.projetospring.entities.OrderItem;
import com.projetospringclericuzi.projetospring.entities.Payment;
import com.projetospringclericuzi.projetospring.entities.Product;
import com.projetospringclericuzi.projetospring.entities.User;
import com.projetospringclericuzi.projetospring.entities.enums.OrderStatus;
import com.projetospringclericuzi.projetospring.repositories.CategoryRepository;
import com.projetospringclericuzi.projetospring.repositories.OrderItemRepository;
import com.projetospringclericuzi.projetospring.repositories.OrderRepository;
import com.projetospringclericuzi.projetospring.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category("Electronics"); 
		Category cat2 = new Category("Books"); 
		Category cat3 = new Category("Computers");
		Category cat4 = new Category("Shoes");
		
		
		Product p1 = new Product("The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, " "); 
		Product p2 = new Product("Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product("Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product("PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product("Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		Product p6 = new Product("O processo", "Livro de Kafka.", 300, "");
		Product p7 = new Product("Olimpikus", "Sapato de corrida", 900, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		p6.getCategories().add(cat2);
		p7.getCategories().add(cat4);
		
		productRepository.saveAll(Arrays.asList(p2, p3, p4, p5, p6, p7));
		
		User u1 = new User(1, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(2, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		
		Order o1 = new Order(1, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1); 
		Order o2 = new Order(2, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2); 
		Order o3 = new Order(3, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		
		OrderItem oi1 = new OrderItem(p1.getPrice(), 2, o1, p1); 
		OrderItem oi2 = new OrderItem(p3.getPrice(), 1, o1, p3); 
		OrderItem oi3 = new OrderItem(p3.getPrice(), 2, o2, p3); 
		OrderItem oi4 = new OrderItem(p5.getPrice(), 2, o3, p5);
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
		
	}
	
	
}
