package com.example.demo;
import com.example.demo.entity.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.util.List;
import com.example.demo.repository.*;

@SpringBootApplication
public class Assignment4Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Assignment4Application.class, args);
		
		BillingRepository billRepo = context.getBean(BillingRepository.class);
		OrderRepository orderRepo = context.getBean(OrderRepository.class);
		
		List<OrderItem> order = orderRepo.findByOrderID(1000);
		

		order.forEach(System.out::println);
		
	}

}
