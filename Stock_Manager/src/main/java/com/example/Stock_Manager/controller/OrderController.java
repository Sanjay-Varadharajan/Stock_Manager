package com.example.Stock_Manager.controller;

import com.example.Stock_Manager.model.Orders;
import com.example.Stock_Manager.service.OrderService;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocker")
public class OrderController {

    @Autowired
    OrderService orderservice;

    @GetMapping("/showorders")
    public List<Orders> allorders(){
        return orderservice.allorders();
    }

    @PostMapping("/addorders")
    public String addorders(@RequestBody Orders orders){
        return orderservice.addorders(orders);
    }

    @PutMapping("/updateorder")
    public String updateorder(@RequestBody Orders orders){
        return orderservice.updateorder(orders);
    }

    @DeleteMapping("/deleteorder")
    public String deleteorder(@RequestBody Orders orders){
        return orderservice.deleteorder(orders);
    }
}
