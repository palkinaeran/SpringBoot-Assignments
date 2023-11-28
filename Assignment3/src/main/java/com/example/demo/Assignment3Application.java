package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.repository.CartRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;

import com.example.demo.service.*;


@SpringBootApplication
public class Assignment3Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(Assignment3Application.class, args);
		
		CartRepository cartRepo = context.getBean(CartRepository.class);
		ProductRepository prodRepo = context.getBean(ProductRepository.class);
		OrderRepository orderRepo = context.getBean(OrderRepository.class);
		
		CartService cartSer = context.getBean(CartService.class);
		ProductService prodSer = context.getBean(ProductService.class);
		OrderService orderSer = context.getBean(OrderService.class);
		
		prodSer.setProdRepo(prodRepo);
		prodSer.save();
		cartSer.setCartRepo(cartRepo);
		cartSer.save();
		orderSer.setOrderRepo(orderRepo);
		orderSer.save();
	}

}
