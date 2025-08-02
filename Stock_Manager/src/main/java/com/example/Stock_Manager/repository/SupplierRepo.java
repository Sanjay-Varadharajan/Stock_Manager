package com.example.Stock_Manager.repository;

import com.example.Stock_Manager.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepo extends JpaRepository<Supplier,Integer> {
}
