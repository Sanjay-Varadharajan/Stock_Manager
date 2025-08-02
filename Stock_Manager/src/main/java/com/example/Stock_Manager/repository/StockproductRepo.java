package com.example.Stock_Manager.repository;

import com.example.Stock_Manager.model.Stockproduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockproductRepo extends JpaRepository<Stockproduct,Integer> {
}
