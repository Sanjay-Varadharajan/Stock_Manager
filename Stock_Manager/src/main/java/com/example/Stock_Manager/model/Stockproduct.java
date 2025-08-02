package com.example.Stock_Manager.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Stockproduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int stockproductId;

    private long productQuantity;

    @JoinColumn(name = "productId")
    @ManyToOne
    private Product product;


    @JoinColumn(name="stockId")
    @ManyToOne
    private Stock stock;

}
