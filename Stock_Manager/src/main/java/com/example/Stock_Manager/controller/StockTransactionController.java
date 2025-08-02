package com.example.Stock_Manager.controller;


import com.example.Stock_Manager.model.StockTransaction;
import com.example.Stock_Manager.service.StockTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stocker")
public class StockTransactionController {


    @Autowired
    StockTransactionService stockTransactionService;


    @GetMapping("/showtransaction")
    public List<StockTransaction> showtransaction(){
        return stockTransactionService.showtransaction();
    }
}
