package com.example.Stock_Manager.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Stock {

    @Id
    private int stockId;


    private boolean stockAvailability;

    @OneToMany(mappedBy ="stock" ,cascade = CascadeType.ALL)
    private List<Stockproduct> stockproduct;

}
