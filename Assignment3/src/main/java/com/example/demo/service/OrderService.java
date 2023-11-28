package com.example.demo.service;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService;

    public Order placeOrder(Cart cart) {
        if (!cart.getProducts().isEmpty()) {
            Order order = new Order();
            order.setProducts(cart.getProducts());
            order.setOrderDate(LocalDateTime.now());
            orderRepository.save(order);

            // Clear the cart after placing the order
            cartService.clearCart(cart);

            return order;
        } else {
            throw new RuntimeException("Cannot place an empty order.");
        }
    }

    public List<Order> viewOrderHistory() {
        // Implement logic to fetch order history
        return orderRepository.findAll();
    }
}
