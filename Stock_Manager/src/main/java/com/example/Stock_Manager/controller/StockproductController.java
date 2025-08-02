package com.example.Stock_Manager.controller;


import com.example.Stock_Manager.model.Stockproduct;
import com.example.Stock_Manager.service.StockproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocker")
public class StockproductController {

    @Autowired
    StockproductService stockproductService;

    @GetMapping("/stockproduct")
    public List<Stockproduct> getallstockproduct() {
        return stockproductService.getallstockproduct();
    }

    @PostMapping("/addstockproduct")
    public String addstockproduct(@RequestBody Stockproduct stockproduct) {
        return stockproductService.addstockproduct(stockproduct);
    }

    @PutMapping("/updatestockproduct")
    public String updatestockproduct(@RequestBody Stockproduct stockproduct) {
        return stockproductService.updateproduct(stockproduct);
    }




}
