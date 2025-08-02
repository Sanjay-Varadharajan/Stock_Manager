package com.example.Stock_Manager.repository;

import com.example.Stock_Manager.model.Partners;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartnerRepo extends JpaRepository<Partners,Integer> {

}
