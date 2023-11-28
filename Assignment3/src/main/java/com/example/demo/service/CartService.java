package com.example.demo.service;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;

    public Cart addToCart(Cart cart, Long productId) {
        Product product = productService.getProductById(productId);
        if (product != null && product.getStock() > 0) {
            cart.getProducts().add(product);
            return cartRepository.save(cart);
        } else {
            throw new RuntimeException("Product not found or out of stock.");
        }
    }

    public Cart removeFromCart(Cart cart, Long productId) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            cart.getProducts().remove(product);
            return cartRepository.save(cart);
        } else {
            throw new RuntimeException("Product not found in the cart.");
        }
    }

    public List<Product> viewCart(Cart cart) {
        // Implement logic to view products in the cart
        return cart.getProducts();
    }

    public void clearCart(Cart cart) {
        cart.getProducts().clear();
        cartRepository.save(cart);
    }
}
