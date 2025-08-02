package com.example.Stock_Manager.repository;

import com.example.Stock_Manager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product,Integer> {
    Optional<Product> findByproductName(String productName);
}

