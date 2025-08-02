package com.example.Stock_Manager.service;


import com.example.Stock_Manager.model.Buyer;
import com.example.Stock_Manager.model.Orders;
import com.example.Stock_Manager.repository.BuyerRepo;
import com.example.Stock_Manager.repository.OrderRepo;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {


    @Autowired
    OrderRepo orderRepo;

    @Autowired
    BuyerRepo buyerRepo;

    public List<Orders> allorders() {
        return orderRepo.findAll();
    }

    public String addorders(Orders orders) {
        orderRepo.save(orders);
        return "Order Placed Successfully";
    }

    public String updateorder(Orders orders) {
        Optional<Orders> check=orderRepo.findById(orders.getOrderId());
        if(check.isEmpty()){
            return "Order Not Found";
        }
        Orders order1=check.get();
        order1.setBuyer(orders.getBuyer());
        order1.setProduct(orders.getProduct());
        order1.setSupplier(orders.getSupplier());
        order1.setProduct1(orders.getProduct1());
        orderRepo.save(order1);
        return "Updated Sucessfully";
    }


    public String deleteorder(Orders orders) {
        Optional<Orders> check=orderRepo.findById(orders.getOrderId());

        if(check.isEmpty()){
            return "Order Not Found..";
        }

        orderRepo.deleteById(orders.getOrderId());
        return "Order deleted...";
    }
}
