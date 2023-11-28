package com.example.demo;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;


@Component
public class CliApp {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. List all products");
            System.out.println("2. Add a product to the cart");
            System.out.println("3. Remove a product from the cart");
            System.out.println("4. View cart");
            System.out.println("5. Place an order");
            System.out.println("6. View order history");
            System.out.println("7. Exit");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // clear buffer
                continue;
            }

            switch (choice) {
                case 1:
                    List<Product> products = productService.listAllProducts();
                    if (!products.isEmpty()) {
                        System.out.println("Available products:");
                        products.forEach(product -> System.out.println(product.getId() + ". " + product.getName()));
                    } else {
                        System.out.println("No products available.");
                    }
                    break;
                case 2:
                    System.out.println("Enter product ID to add to the cart:");
                    try {
                        Long productIdToAdd = scanner.nextLong();
                        cart = cartService.addToCart(cart, productIdToAdd);
                        System.out.println("Product added to the cart successfully.");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid product ID. Please enter a number.");
                        scanner.nextLine(); // clear buffer
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Enter product ID to remove from the cart:");
                    try {
                        Long productIdToRemove = scanner.nextLong();
                        cart = cartService.removeFromCart(cart, productIdToRemove);
                        System.out.println("Product removed from the cart successfully.");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid product ID. Please enter a number.");
                        scanner.nextLine(); // clear buffer
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    List<Product> cartProducts = cartService.viewCart(cart);
                    if (!cartProducts.isEmpty()) {
                        System.out.println("Products in the cart:");
                        cartProducts.forEach(product -> System.out.println(product.getName()));
                    } else {
                        System.out.println("Cart is empty.");
                    }
                    break;
                case 5:
                    try {
                        Order placedOrder = orderService.placeOrder(cart);
                        System.out.println("Order placed successfully. Order ID: " + placedOrder.getId());
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    List<Order> orderHistory = orderService.viewOrderHistory();
                    if (!orderHistory.isEmpty()) {
                        System.out.println("Order history:");
                        orderHistory.forEach(order -> System.out.println("Order ID: " + order.getId() +
                                ", Order Date: " + order.getOrderDate()));
                    } else {
                        System.out.println("No order history available.");
                    }
                    break;
                case 7:
                    System.out.println("Exiting application...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}