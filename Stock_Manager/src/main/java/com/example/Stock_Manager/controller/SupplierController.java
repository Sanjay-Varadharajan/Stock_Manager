package com.example.Stock_Manager.controller;

import com.example.Stock_Manager.model.Supplier;
import com.example.Stock_Manager.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stocker")
public class SupplierController {


    @Autowired
    SupplierService supplierService;


    @GetMapping("/suppliers")
    public List<Supplier> getallsupplier(){
        return supplierService.getallsupplier();
    }

    @PostMapping("/addsupplier")
    public String addsupplier(@RequestBody Supplier supplier){
        return supplierService.addsupplier(supplier);
    }

    @PutMapping("/updatesupplier")
    public String updatesupplier(@RequestBody Supplier supplier){
        return supplierService.updatesupplier(supplier);
    }

    @GetMapping("/supplier")
    public Optional<Supplier> getsupplier(@PathVariable("supplierId")int supplierId){
        return supplierService.getsupplier(supplierId);
    }

    @DeleteMapping("/deletesupplier")
    public String deletesupplier(@RequestParam("supplierId")int supplierId){
        return supplierService.deletesupplier(supplierId);
    }

}
