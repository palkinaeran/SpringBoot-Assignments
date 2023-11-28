package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.*;
import com.example.demo.service.*;
public interface CartRepository extends JpaRepository<Cart, Long>{

}
