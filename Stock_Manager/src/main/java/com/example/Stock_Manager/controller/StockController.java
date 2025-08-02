package com.example.Stock_Manager.controller;


import com.example.Stock_Manager.model.Stock;
import com.example.Stock_Manager.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocker")
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping("/stocks")
    public List<Stock> getallstock(){
        return stockService.getallstock();
    }

    @PostMapping("/addstock")
    public String addstock(@RequestBody Stock stock){
        return stockService.addstock(stock);
    }
}
