package com.example.Stock_Manager.controller;


import com.example.Stock_Manager.model.Buyer;
import com.example.Stock_Manager.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stocker")
public class BuyerController {


    @Autowired
    BuyerService buyerService;

    @GetMapping("/buyers")
    public List<Buyer> buyers(){
        return buyerService.buyers();
    }

    @GetMapping("/buyer/{buyerId}")
    public Optional<Buyer> buyer(@PathVariable("buyerId")int buyerId){
        return buyerService.buyer(buyerId);
    }


    @PostMapping("/addbuyers")
    public String addbuyers(@RequestBody Buyer buyer){
        return buyerService.addbuyer(buyer);
    }

    @PutMapping("/updatebuyer")
    public String updatebuyer(@RequestBody Buyer buyer){
        return buyerService.updatebuyer(buyer);
    }

    @DeleteMapping("/deletebuyer")
    public String deletebuyer(@RequestParam("buyerId")int buyerId){
        return buyerService.deletebuyer(buyerId);
    }

}
