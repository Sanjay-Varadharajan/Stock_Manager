package com.example.Stock_Manager.service;


import com.example.Stock_Manager.model.Product;
import com.example.Stock_Manager.model.Stock;
import com.example.Stock_Manager.model.Stockproduct;
import com.example.Stock_Manager.repository.ProductRepo;
import com.example.Stock_Manager.repository.StockRepo;
import com.example.Stock_Manager.repository.StockproductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    StockRepo stockRepo;



    public List<Stock> getallstock() {
        return stockRepo.findAll();
    }

    public void updateavailability(int stockId){
        Optional<Stock> check=stockRepo.findById(stockId);  //gets data from the stock table

        if(check.isPresent()){         //checks if stock table has this data
             Stock stock=check.get();          //if yes gets the data
            boolean available=false;           //set defualt avialability as false


            for(Stockproduct sp: stock.getStockproduct()){    //iterates the whole product Quantity in stock product
                if(sp.getProductQuantity()>0){            //if quantity>0
                    available=true;                       //setting availability to true
                    break;                                 //then break
                }
            }
            stock.setStockAvailability(available);      //setting stockavailabilty by available
            stockRepo.save(stock);                          //saving the stock
        }
    }

    public String addstock(Stock stock) {
        stockRepo.save(stock);
        return "Stock added";
    }
}
