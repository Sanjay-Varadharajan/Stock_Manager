package com.example.Stock_Manager.repository;

import com.example.Stock_Manager.model.StockTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockTransactionRepo extends JpaRepository<StockTransaction,Integer> {
}
