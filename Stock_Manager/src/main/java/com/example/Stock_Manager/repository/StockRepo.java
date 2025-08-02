package com.example.Stock_Manager.repository;

import com.example.Stock_Manager.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepo extends JpaRepository<Stock,Integer> {
}
