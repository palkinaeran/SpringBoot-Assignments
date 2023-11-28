package com.example.demo.entity;
import com.example.demo.repository.*;
import com.example.demo.service.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Order {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToMany
	    private List<Product> products;

	    @Column(name = "orderDate")
	    private LocalDateTime orderDate;

		public Order(Long id, List<Product> products, LocalDateTime orderDate) {
			super();
			this.id = id;
			this.products = products;
			this.orderDate = orderDate;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public List<Product> getProducts() {
			return products;
		}

		public void setProducts(List<Product> products) {
			this.products = products;
		}

		public LocalDateTime getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(LocalDateTime orderDate) {
			this.orderDate = orderDate;
		}
	    
	    
 
}
