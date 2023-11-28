package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import com.example.demo.repository.*;
import com.example.demo.service.*;
@Entity
public class Cart {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Product> products;

	public Cart(Long id, List<Product> products) {
		super();
		this.id = id;
		this.products = products;
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
    
    

}
