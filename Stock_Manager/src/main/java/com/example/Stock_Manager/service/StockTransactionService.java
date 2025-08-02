package com.example.Stock_Manager.service;


import com.example.Stock_Manager.model.Orders;
import com.example.Stock_Manager.model.StockTransaction;
import com.example.Stock_Manager.repository.OrderRepo;
import com.example.Stock_Manager.repository.StockTransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockTransactionService {


    @Autowired
    StockTransactionRepo stockTransactionRepo;

    @Autowired
    OrderRepo orderRepo;


    public List<StockTransaction> showtransaction() {
        return stockTransactionRepo.findAll();
    }

    public String updation(Orders order) {
        Optional<Orders> check = orderRepo.findById(order.getOrderId());
        if (check.isPresent()) {
            Orders orders = check.get();

            StockTransaction up = new StockTransaction();

            up.setBuyer(orders.getBuyer());
            up.setProduct(orders.getProduct());
            up.setReleasedOn(orders.getOrderPlaced());

            stockTransactionRepo.save(up);
            return "Updated";
        } else {
            throw new RuntimeException("Order not found with ID: " + order.getOrderId());
        }

    }
}