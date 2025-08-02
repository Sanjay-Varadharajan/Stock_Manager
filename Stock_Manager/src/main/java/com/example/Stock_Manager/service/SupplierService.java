package com.example.Stock_Manager.service;


import com.example.Stock_Manager.model.Supplier;
import com.example.Stock_Manager.repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {


    @Autowired
    SupplierRepo supplierRepo;


    public List<Supplier> getallsupplier() {
        return supplierRepo.findAll();
    }

    public String addsupplier(Supplier supplier) {
        Optional<Supplier> check=supplierRepo.findById(supplier.getSupplierId());

        if(check.isPresent()){
            return "Supplier Already Exist..";
        }

        supplierRepo.save(supplier);
        return "Supplier Added Sucessfully...";
    }

    public String updatesupplier(Supplier supplier) {

        Optional<Supplier> check=supplierRepo.findById(supplier.getSupplierId());

        if(check.isEmpty()){
            return "Supplier Not Found....";
        }

        Supplier sup=check.get();

        sup.setSupplierName(supplier.getSupplierName());
        sup.setAccountNo(supplier.getAccountNo());
        sup.setSupplierAddress(supplier.getSupplierAddress());
        sup.setSupplierMail(supplier.getSupplierMail());
        sup.setSupplierPhone(supplier.getSupplierPhone());
        
        supplierRepo.save(sup);
        
        return "Supplier Updated Sucessfully....";

    }

    public Optional<Supplier> getsupplier(int supplierId) {
        Optional<Supplier> check=supplierRepo.findById(supplierId);

        if(check.isEmpty()){
            throw new RuntimeException("Supplier Not Found");
        }

        return supplierRepo.findById(supplierId);
    }

    public String deletesupplier(int supplierId) {

        Optional<Supplier> suppliercheck=supplierRepo.findById(supplierId);

        if(suppliercheck.isEmpty()){
            return "Supplier Not Found...";
        }

        supplierRepo.deleteById(supplierId);
        return "Supplier Deleted Sucessfully";
    }

}
