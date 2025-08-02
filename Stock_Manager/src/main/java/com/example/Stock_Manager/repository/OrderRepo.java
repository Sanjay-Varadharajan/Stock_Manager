package com.example.Stock_Manager.repository;

import com.example.Stock_Manager.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Orders,Integer> {
}
