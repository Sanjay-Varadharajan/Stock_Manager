package com.example.Stock_Manager.service;


import com.example.Stock_Manager.model.Stockproduct;
import com.example.Stock_Manager.repository.StockproductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockproductService {


    @Autowired
    StockproductRepo stockproductRepo;



    public List<Stockproduct> getallstockproduct() {
        return stockproductRepo.findAll();
    }

    public String addstockproduct(Stockproduct stockproduct) {
        Optional<Stockproduct> check=stockproductRepo.findById(stockproduct.getStockproductId());

        if(check.isPresent()){
            return "Data Already Found..";
        }

        stockproductRepo.save(stockproduct);
        return "Data Saved Sucessfully";
    }

    public String updateproduct(Stockproduct stockproduct) {

        Optional<Stockproduct> check=stockproductRepo.findById(stockproduct.getStockproductId());

        if(check.isEmpty()){
            return "Data Not Found...";
        }

        Stockproduct sp=check.get();

        stockproductRepo.save(sp);

        return "Data Updated Sucessfully";
    }
}
