package com.example.demo.repository;
import com.example.demo.entity.*;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.JpaRepository;
public interface BillingRepository extends JpaRepository<Billing, Long> {

    @Query("SELECT b FROM Billing b WHERE b.customer = :customer")
    List<Billing> findBillingsByCustomer(@Param("customer") Customer customer);
}
