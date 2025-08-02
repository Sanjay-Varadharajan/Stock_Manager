package com.example.Stock_Manager.service;


import com.example.Stock_Manager.model.Buyer;
import com.example.Stock_Manager.repository.BuyerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerService {

    @Autowired
    BuyerRepo buyerRepo;


    public List<Buyer> buyers() {
        return buyerRepo.findAll();
    }

    public Optional<Buyer> buyer(int buyerId) {
        return buyerRepo.findById(buyerId);
    }


    public String addbuyer(Buyer buyer) {
        Optional<Buyer> check=buyerRepo.findByBuyerNameAndBuyerId(buyer.getBuyerName(),buyer.getBuyerId());
        if(check.isPresent()){
            return "Buyer Already Available";
        }

        buyerRepo.save(buyer);
        return "Buyer Added Sucessfully";
    }


    public String updatebuyer(Buyer buyer) {
        Optional<Buyer> check=buyerRepo.findById(buyer.getBuyerId());

        if(check.isEmpty()){
            return "Buyer Not Found";
        }

        Buyer buy=check.get();

        buy.setBuyerName(buyer.getBuyerName());
        buy.setBuyerAddress(buyer.getBuyerAddress());
        buy.setBuyerPhone(buyer.getBuyerPhone());
        buy.setBuyerAge(buyer.getBuyerAge());
        buy.setBuyerAccountno(buyer.getBuyerAccountno());
        buy.setBuyerMail(buyer.getBuyerMail());

        buyerRepo.save(buy);

        return "Buyer Updated Sucessfully";
    }


    public String deletebuyer(int buyerId) {
        if (!buyerRepo.existsById(buyerId)) {
            return "Buyer Not Found..";
        }

        buyerRepo.deleteById(buyerId);
        return "Buyer Deleted..";

    }
}
