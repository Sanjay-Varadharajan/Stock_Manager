package com.example.Stock_Manager.repository;

import com.example.Stock_Manager.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuyerRepo extends JpaRepository<Buyer,Integer> {
    Optional<Buyer> findByBuyerNameAndBuyerId(String buyerName, int buyerId);
}

