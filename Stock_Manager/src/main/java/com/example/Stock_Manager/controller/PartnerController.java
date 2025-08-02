package com.example.Stock_Manager.controller;


import com.example.Stock_Manager.model.Partners;
import com.example.Stock_Manager.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stocker")
public class PartnerController {


    @Autowired
    PartnerService partnerService;

    @GetMapping("/partners")
    public List<Partners> getallpartner(){
        return partnerService.getallpartner();
    }

    @GetMapping("/partner/{partnerId}")
    public Optional<Partners> getpartner(@PathVariable("PartnerId")int partnerId){
        return partnerService.getpartner(partnerId);
    }

    @PostMapping("/addpartner")
    public String addpartner(@RequestBody Partners partners){
        return partnerService.addpartner(partners);
    }

    @PutMapping("/updatepartner")
    public String updatepartner(@RequestBody Partners partners){
        return partnerService.updatepartner(partners);
    }


    @DeleteMapping("/deletepartner")
    public String deletepartner(@RequestBody Partners partners){
        return partnerService.deletepartner(partners);
    }





}
